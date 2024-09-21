public class Sala {
    int bloco;
    int sala;
    int capacidade;
    boolean acessivel;

    Sala(){
        this.bloco = 0;
        this.sala = 0;
        this.capacidade = 0;
        this.acessivel = false;
    }

    Sala(int bloco, int sala, int capacidade, boolean acessivel){
        this.bloco = bloco;
        this.sala = sala;
        this.capacidade = capacidade;
        this.acessivel = acessivel;
    }

    String tratarBooleano(){
        if (this.acessivel == true){
            return "acessível";
        }

        else {
            return "não acessível";
        }
    }

    String getDescricao(){
        return ("Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, " + tratarBooleano() + ")");
    }
}
