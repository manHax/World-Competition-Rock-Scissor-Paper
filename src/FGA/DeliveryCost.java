package FGA;

public class DeliveryCost {
    private int jumlahBarang, harga, berat, jarakTempuh;

    public int rumusHarga(int length, int height, int width, int jarakTempuh, int jumlahBarang)
    {
        this.berat = (length * height * width)/6000;
        this.jarakTempuh = jarakTempuh;
        this.jumlahBarang = jumlahBarang;

        this.harga = this.berat * this.jarakTempuh * this.jumlahBarang;

        return this.harga;
    }

    public void cetakHarga()
    {
        System.out.println("Harga:"+ this.harga + " untuk " + this.jumlahBarang + " barang dan " + this.jarakTempuh + " KM");
    }
}
