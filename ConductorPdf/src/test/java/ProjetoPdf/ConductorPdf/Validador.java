package ProjetoPdf.ConductorPdf;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import br.com.caelum.stella.boleto.bancos.Bancos;
import br.com.caelum.stella.boleto.bancos.GeradorDeLinhaDigitavel;
public class Validador {
    
        
    public static void validadorPdf() throws InvalidPasswordException, IOException {
        String  texto = "23792.37403 60009.530910 06000.026002 1 00000000000000"; //Acordo Santander - OK
          //  Utils.encontrarLinhaDigitavel(texto);
        
            
                String caminhoArquivo = "C:\\Users\\T-Gamer\\Documents\\kevin utils\\Fatura - Visualizar Segunda Via_160024.PDF";
                File arquivo = new File(caminhoArquivo);
                PDDocument documento = PDDocument.load(arquivo);
                String stringPdf = new PDFTextStripper().getText(documento);
                System.out.println(stringPdf);
                
                
            
                int inicioLinhaDigitavel = 0;
                int fimLinhaDigitavel = 0;
                String linhaDigitavelPdf = stringPdf.substring(inicioLinhaDigitavel, fimLinhaDigitavel);
                
                GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
                String LinhaDigitavelGerada = gerador.geraLinhaDigitavelPara(caminhoArquivo, Bancos.BANCO_DO_BRASIL.getBanco());
                String linhaDigitavelGerada = null;
                LinhaDigitavelGerada.replaceAll(" ", "");
                String LinhaDigitavelTela = null;
                linhaDigitavelPdf.replaceAll(" ", "").replaceAll("\t", "");
                System.out.println("Linha digitável gerada: "+LinhaDigitavelGerada);
                
                boolean estaoIguais = LinhaDigitavelGerada.equals("stringLinhaDigitavelTela");
                System.out.println("Estão iguais? "+estaoIguais);
                System.out.println("Linha digitavel gerada: "+LinhaDigitavelGerada); 
                System.out.println("Linha digitavel boleto: "+linhaDigitavelPdf);
        
                    
                
        }
        public static void main(String[] args) throws InvalidPasswordException, IOException {
            validadorPdf();
        }
    
}