package dto.client;

public enum ClientStatus {
    //0
    NORMAL(0),
    //скидка 5%
    STANDART(5),
    //скидка 10%
    PREMIUM(10);
    final int sale;
    ClientStatus(int sale) {
        this.sale = sale;
    }

    public int getSale() {
        return sale;
    }
}
