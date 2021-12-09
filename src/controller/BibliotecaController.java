package controller;

import model.CD;
import model.DVD;
import model.Midia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BibliotecaController {
    private MidiasController midiasController;
    private File arq;

    public BibliotecaController( MidiasController midiasController,String filePath) {
        this.arq =  new File(filePath);
        this.midiasController = midiasController;
    }

    public boolean arquivoExiste() throws IOException {
        try {
            boolean existe = !arq.createNewFile();
            System.out.println(arq.getAbsolutePath());
            return existe;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    public void sobrescreveArquivo() throws Exception{
        Midia[] itens = midiasController.listarTodas();
        try{
            arquivoExiste();
            FileWriter escritora = new FileWriter(arq.getPath());
            for (Midia midia:itens) {
                escritora.write(midia.getTipo() + " -!- " + midia.getDetalhes()+"\n");
            }
            escritora.close();
        }catch(IOException e){
            throw e;
        }catch(Exception e){
            throw e;
        }
    }
    public Midia[] leArquivo() throws Exception{
        int tamanho = 0;
        Midia[] itens = new Midia[0];
        try{
            arquivoExiste();
            Scanner reader = new Scanner(arq);
            while (reader.hasNextLine()){
                Midia[] itens2 = new Midia[tamanho+1];
                String linha = reader.nextLine();
                String[] obj = linha.split("-!-");
                if (obj[0].trim().equals("model.DVD")){
                    DVD carregada = new DVD(Integer.parseInt(obj[3].trim()), Double.parseDouble(obj[2].trim()),
                            obj[1].trim(), obj[4].trim());
                    itens2[tamanho] = carregada;
                }else{
                    CD carregada = new CD(Integer.parseInt(obj[3].trim()), Double.parseDouble(obj[2].trim()),
                            obj[1].trim(), Integer.parseInt(obj[4].trim()));;
                    itens2[tamanho] = carregada;
                }
                for (int i = 0; i < tamanho; i++) {
                    itens2[i] = itens[i];
                }
                itens = itens2;
                tamanho++;
            }
            Object[] rtn = new Object[2];
            return itens;
        }catch(Exception e){
            throw e;
        }
    }

}
