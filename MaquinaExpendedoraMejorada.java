public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // Lleva la cuenta de cuantas veces se usa el metodo
    private int numeroDeUsos;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
    }

    /**
     * Nuevo constructor el cual el precio de billete es fijo, la estacion de origen es siempre la misma
     * y la de destino tambien sea siempre la misma.
     */
    public MaquinaExpendedoraMejorada() {
        precioBillete = 10;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Leon";
        estacionDestino = "Pucela";
    }
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    
    /**
     * Cuanta el numero de billetes vendidos.
     */
    public int getNumeroBilletesVendidos(){
        return numeroDeUsos;
    }
    /**
     *  Imprime el numero de billetes vendidos.
     */
    public void imprimirNumeroBilletesVendidos(){
        System.out.println("#El total de billetes vendidos son:");
        System.out.println(numeroDeUsos);
        
    }
    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
         
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();
            // Realiza una suma al numero de usos 
            numeroDeUsos = numeroDeUsos + 1;
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
        }
        else {
            System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
            
            
        }            
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**Al invocar el método sobre un objeto del tipo MaquinaExpendedoraMejorada se vacía todo el dinero que hay en ella (incluyendo los dos depósitos, es decir 
    * ,si fuera el caso, incluyendo también el dinero que el usuario que esté usando la máquina en este momento haya metido y que no haya usado aún para comprar un billete).
    *El método debe devolver la cantidad total de dinero extraída de la máquina.
    *Solo se permite una instrucción return en el método que, además, debe ser la última del método.
    */
    public int vaciarDineroDeLaMaquina(){
        
        int dineroAcumulado = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual != 0) {
            dineroAcumulado = -1;
            System.out.println("Actualmente la máquina se encunetra en desuso por que aún se están haciendo operaciones");
        }
        else {
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        }
        return dineroAcumulado;
    }
}
