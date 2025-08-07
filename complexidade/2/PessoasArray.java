public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;

        System.out.println("Procurando o nome: \"" + nome + "\"");
        int left = 0;
        int right = nomes.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("Passando pelo indice: " + mid);
            int cmp = nomes[mid].compareTo(nome);
            if (cmp == 0) {
                System.out.println("Nome " + nome + " encontrado na posição " + mid);
                encontrado = true;
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
}
