import br.com.rodrigovianna.dominio.Bootcamp;
import br.com.rodrigovianna.dominio.Curso;
import br.com.rodrigovianna.dominio.Dev;
import br.com.rodrigovianna.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        final var cursoJava = new Curso("Java", "Descrição do curso de Java", 6);
        final var cursoDotNet = new Curso(".NET", "Descrição do curso de .NET", 8);

        final var mentoria = new Mentoria("Mentoria de Programação", "Descrição da mentoria de Programação");

        final var bootcamp = new Bootcamp("Bootcamp Java & .NET", "Descrição do Bootcamp");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoDotNet);
        bootcamp.getConteudos().add(mentoria);

        final var dev = new Dev("Rogério");
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + dev.getConteudosInscritos());
        dev.progredir();
        System.out.println("Conteúdos inscritos: " + dev.getConteudosInscritos());
        System.out.println("Conteúdos concluídos: " + dev.getConteudosConcluidos());

    }
}
