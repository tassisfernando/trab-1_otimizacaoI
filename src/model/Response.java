package model;

public class Response {

    private Double maxMinValor;
    private Double x;
    private Double y;

    public Response(Double maxMinValor, Double x, Double y) {
        this.maxMinValor = maxMinValor;
        this.x = x;
        this.y = y;
    }

    public Double getMaxMinValor() {
        return maxMinValor;
    }

    public void setMaxMinValor(Double maxMinValor) {
        this.maxMinValor = maxMinValor;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
