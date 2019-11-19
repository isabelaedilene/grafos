package com.company;

public class GrafoSimples extends Grafo {

    private Vertice encontrarVertice(Vertice vertice){
        int index = this.vertices.indexOf(vertice);
        Vertice v = this.vertices.get(index);
        return v;
    }

    private boolean temLoop(){
        boolean temLoop = false;
        for (Vertice vIndice : this.vertices){
            for (Vertice vAdjacente : this.vertices){
                if (vIndice.nome.equals(vAdjacente.nome)){
                    temLoop = true;
                }
            }
        }
        return temLoop;
    }

    // Método 2
    public int getGrau(Vertice vertice){
       return vertice.verticesAdjacentes.size();
    }

    // Método 3
    public boolean eRegular(){
        return verificarIgualdadeGrau(this.getGrau(this.vertices.get(0)));
    }

    // Método 4
    public boolean eIsolado(Vertice vertice){
        return this.getGrau(vertice) == 0;
    }

    // Método 5
    public boolean ePendente(Vertice vertice){
        return this.getGrau(vertice) == 1;
    }

    // Método 6
    public boolean eNulo(){
        return verificarIgualdadeGrau(0);
    }

    // Método 7
    public boolean eCompleto(){
        if(!this.temLoop()){
            return verificarIgualdadeGrau(this.vertices.size() - 1);
        } else {
            return false;
        }
    }

    private boolean verificarIgualdadeGrau(int grauBase){
        int qtdVertices = this.vertices.size();
        int grau, cont = 0;

        do {
            grau = this.getGrauSemLoop(this.vertices.get(cont++));
        }while (grauBase == grau && cont < qtdVertices);

        return (grauBase == grau);
    }

    private int getGrauSemLoop(Vertice vertice){
        int contLoop = 0;
        Vertice v = encontrarVertice(vertice);
        for (Vertice vAdj : v.verticesAdjacentes){
            if (vertice.nome.equals(vAdj.nome)) {
                contLoop++;
            }
        }
        return vertice.verticesAdjacentes.size() - contLoop;
    }

    /* public boolean eCompleto(){
        boolean adjacente, completo = false;
        if (this.eRegular()){
            completo = true;

            for (Vertice v : this.vertices){
                if(completo){
                    for(Vertice vAdj : this.vertices){
                        adjacente = super.eAdjacente(v, vAdj);
                        if(!adjacente){
                            completo = false;
                        }
                    }
                }
            }
        }
        return completo;
    } */
}