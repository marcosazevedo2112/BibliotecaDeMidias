package controller;

import model.Midia;

public class MidiasController {
    private class MidiaLista {
        private int tamanho = 0;
        private Midia[] itens = new Midia[tamanho];

        public int getTamanho() {
            return tamanho;
        }

        public void setTamanho(int tamanho) {
            this.tamanho = tamanho;
        }

        public Midia[] getItens() {
            return itens;
        }

        public void setItens(Midia[] itens) {
            this.itens = itens;
        }

        public void adiciona(Midia midia) {
            if (midia == null) throw new IllegalArgumentException("midia não é um argumento valido");

            Midia[] itens2 = new Midia[tamanho + 1];
            for (int i = 0; i < tamanho; i++) {
                itens2[i] = itens[i];
            }
            itens2[tamanho] = midia;
            tamanho++;
            itens = itens2;

        }

        public Midia remove(int p) {
            if (p < 0 || p > 999999) throw new IllegalArgumentException("a posição para remover um item não é valida");

            boolean removido = false;
            Midia[] itens2 = new Midia[tamanho - 1];
            Midia midiaRemovida = null;

            for (int i = 0; i < tamanho; i++) {
                if (!removido) {
                    if (itens[i].getCodigo() == p) {
                        midiaRemovida = itens[i];
                        if (i == 0) {
                            for (int j = 1; j < tamanho; j++) {
                                itens2[j - 1] = itens[j];
                            }
                            itens = itens2;
                            tamanho--;
                            return midiaRemovida;
                        } else {
                            removido = true;
                            continue;
                        }
                    }
                    itens2[i] = itens[i];

                }
                itens2[i] = itens[i];
            }
            tamanho--;
            itens = itens2;
            if (midiaRemovida != null) return midiaRemovida;
            else tamanho++;
            throw new IllegalArgumentException("a posição para remover um item não é valida");
        }

        public Midia retornaUma(int p) {
            if (p < 0 || p > 999999) throw new IllegalArgumentException("a posição para remover um item não é valida");

            for (int i = 0; i < tamanho; i++) {
                if (itens[i].getCodigo() == p) {
                    return itens[i];
                }
            }
            throw new IllegalArgumentException("a posição para remover um item não é valida");
        }

        public Midia[] retornaTodas() {
            return itens;
        }
    }

    private MidiaLista lista = new MidiaLista();

    public void cadastrar(Midia midia) {
        lista.adiciona(midia);
    }

    public Midia excluir(int p) {
        return lista.remove(p);
    }

    public Midia pesquisa(int p) {
        return lista.retornaUma(p);
    }

    public void carregarMidias(Midia[] midias){
        lista.setItens(midias);
    }

    public void carregarTamanho(int t){
        lista.setTamanho(t);
    }

    public Midia[] listarTodas() {
        return lista.retornaTodas();
    }
}
