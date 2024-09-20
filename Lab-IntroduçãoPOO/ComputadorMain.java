public class ComputadorMain {
    public static void main(String[] args) {
        // Criando objetos da classe Processador
        Processador proc1 = new Processador("Intel", "i7", 3.2, 8);
        Processador proc2 = new Processador("AMD", "Ryzen 5", 3.6, 6);

        // Criando objetos da classe Memoria
        Memoria mem1 = new Memoria("Kingston", "DDR4", 8, 3.2, 2);
        Memoria mem2 = new Memoria("Corsair", "DDR4", 16, 3.6, 4);

        // Criando objetos da classe Disco
        Disco disco1 = new Disco("Seagate", "SSD", 1024, 1500); // Disco de 1TB
        Disco disco2 = new Disco("Western Digital", "HDD", 2048, 4000); // Disco de 2TB

        // Criando objetos da classe Computador
        Computador computador1 = new Computador("Dell", proc1, mem1, disco1);
        Computador computador2 = new Computador("HP", proc2, mem2, disco2);

        // Exibindo a descrição completa dos computadores
        System.out.println(computador1.getDescricao());
        System.out.println(computador2.getDescricao());
    }
}
