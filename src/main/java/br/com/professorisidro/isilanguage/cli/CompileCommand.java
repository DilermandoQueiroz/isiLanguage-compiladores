package br.com.professorisidro.isilanguage.cli;

import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
import br.com.professorisidro.isilanguage.helper.IsiWarning;
import br.com.professorisidro.isilanguage.parser.IsiLangLexer;
import br.com.professorisidro.isilanguage.parser.IsiLangParser;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "compile", description = "Compiles a program written in IsiLanguage")
public class CompileCommand implements Runnable {

    @Parameters(arity = "1", paramLabel = "<programPath>", description = "path to the program to be compiled")
    private String program;

    public void run() {
        try {
            // leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
            IsiLangLexer lexer = new IsiLangLexer(CharStreams.fromFileName(program));

            // crio um "fluxo de tokens" para passar para o PARSER
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            // crio meu parser a partir desse tokenStream
            IsiLangParser parser = new IsiLangParser(tokenStream);

            parser.prog();

            ArrayList<String> warningList = parser.warnings();
            IsiWarning.printWarning(warningList);

            System.out.println("Compilation Successful");

            parser.exibeComandos();

            parser.generateCode();
        } catch (IsiSemanticException ex) {
            System.err.println("Semantic error - " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("ERROR " + ex.getMessage());
        }
    }

}
