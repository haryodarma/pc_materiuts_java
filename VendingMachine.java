import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {

        ArrayList<Minuman> dataMinuman = new ArrayList<>();
        dataMinuman.add(new Minuman("Sprite", 4000, 10));

        Boolean condition = true;

        Scanner scanner = new Scanner(System.in);

        while (condition) {
            try {
                System.out.println("========== SIlahkan Pilih Opsi ==========");
                System.out.println("1. Order Minuman");
                System.out.println("2. Maintanance Menu");
                System.out.println("3. Tutup Aplikasi");
                System.out.println("=========================================");
                int opsi = scanner.nextInt();

                if (opsi == 1) {
                    System.out.println("========== SIlahkan Pilih Minuman ==========");
                    for (int i = 0; i < dataMinuman.size(); i++) {
                        System.out.println(
                                i + 1 + ". " + dataMinuman.get(i).nama + " | " + dataMinuman.get(i).harga + " | "
                                        + dataMinuman.get(i).stok);
                    }

                    System.out.println("============================================");

                    int opsiMinuman = scanner.nextInt();

                    if (dataMinuman.get(opsiMinuman - 1).stok > 0) {
                        Minuman minumanDipilih = dataMinuman.get(opsiMinuman - 1);
                        System.out.println("========== Minuman Telah Dipilih ==========");
                        System.out.println("Anda Memilih Minuman " + dataMinuman.get(opsiMinuman - 1).nama);
                        System.out.println("===========================================");
                        dataMinuman.get(opsiMinuman - 1).stok--;
                    } else {
                        System.out.println("========== !!!!!!!! ==========");
                        System.out.println("Stok Minuman " + dataMinuman.get(opsiMinuman - 1).nama + " Telah Habis");
                        System.out.println("==============================");
                    }
                } else if (opsi == 2) {
                    System.out.println("========== SIlahkan Pilih Opsi ==========");
                    System.out.println("1. Tambah Minuman");
                    System.out.println("2. Hapus Minuman");
                    System.out.println("3. Ubah Minuman");
                    System.out.println("=========================================");

                    int opsiCRUD = scanner.nextInt();

                    if (opsiCRUD == 1) {
                        scanner.nextLine();

                        System.out.print("Silahkan Masukkan Nama Minuman : ");

                        String namaMinumanBaru = scanner.nextLine();

                        System.out.println();

                        Integer hargaMinumanBaru = null;
                        Integer stokMinumanBaru = null;
                                            boolean conditionHarga = true;

                        while (conditionHarga) {

                            try {
                                System.out.print("Silahkan Masukkan Harga Minuman : ");
                                hargaMinumanBaru = scanner.nextInt();
                                System.out.println();
                                conditionHarga = false;
                            } catch (Exception e) {
                                System.out.println("Format Salah ( contoh : 199999 )");
                            }

                        }
                        boolean conditionStok = true;
                        while (conditionStok) {

                            try {
                                System.out.print("Silahkan Masukkan Stok Minuman : ");
                                stokMinumanBaru = scanner.nextInt();
                                conditionStok = false;
                            } catch (Exception e) {
                                System.out.println("Format Salah ( contoh : 199999 )");
                            }
                        }
                        System.out.println();

                        if (hargaMinumanBaru != null && stokMinumanBaru != null) {

                            dataMinuman.add(new Minuman(namaMinumanBaru, hargaMinumanBaru,
                                    stokMinumanBaru));
                        }

                    } else if (opsiCRUD == 2) {
                        System.out.println("============ Hapus Minuman ============");
                        for (int i = 0; i < dataMinuman.size(); i++) {
                            System.out.println(
                                    i + 1 + ". " + dataMinuman.get(i).nama + " | " + dataMinuman.get(i).harga + " | "
                                            + dataMinuman.get(i).stok);
                        }
                        System.out.println("=======================================");
                        boolean cNoMinuman = true;
                        while (cNoMinuman) {
                            try {

                                int noHapus = scanner.nextInt();

                                dataMinuman.remove(noHapus - 1);

                                cNoMinuman = false;
                            } catch (Exception e) {
                                System.out.println("Format Salah ( contoh: 1 )");
                            }
                        }

                    } else if (opsiCRUD == 3) {
                        System.out.println("========== SIlahkan Pilih Minuman ==========");
                        System.out.println("=============== Untuk Diubah ===============");
                        for (int i = 0; i < dataMinuman.size(); i++) {
                            System.out.println(
                                    i + 1 + ". " + dataMinuman.get(i).nama + " | " + dataMinuman.get(i).harga + " | "
                                            + dataMinuman.get(i).stok);
                        }

                        System.out.println("============================================");
                        Integer noMinuman = null;

                        try {

                            noMinuman = scanner.nextInt();

                        } catch (Exception e) {
                            System.out.println("Anda Salah Format");
                        }

                        System.out.println("========== Pilih Content ==========");
                        System.out.println("1. Ubah Nama");
                        System.out.println("2. Ubah Harga");
                        System.out.println("3. Ubah Stok");
                        System.out.println("4. Ubah Semua");
                        System.out.println("===========================================");
                        Integer noContent = null;
                        try {

                            noContent = scanner.nextInt();

                        } catch (Exception e) {
                            System.out.println("Anda Salah Format");
                        }
                        if (noContent == 1) {
                            scanner.nextLine();
                            System.out.println("Masukkan Nama Baru : ");

                            String namaBaru = scanner.nextLine();

                            dataMinuman.get(noMinuman - 1).nama = namaBaru;
                            
                            System.out.println();
                        } else if (noContent == 2) {
                            System.out.println("Masukkan Harga Baru : ");

                            int hargaBaru = scanner.nextInt();
                            dataMinuman.get(noMinuman - 1).harga = hargaBaru;

                            System.out.println();
                        } else if (noContent == 3) {
                            System.out.println("Masukkan Stok Baru : ");

                            int stokBaru = scanner.nextInt();
                            dataMinuman.get(noMinuman - 1).stok = stokBaru;

                            System.out.println();
                        } else if (noContent == 4) {
                            boolean kondisiUbah = true;
                            while (kondisiUbah) {
                                try {
                                    scanner.nextLine();

                                    System.out.println("Masukkan Nama Baru : ");
                                    String namaBaru = scanner.nextLine();

                                    System.out.println();

                                    System.out.println("Masukkan Harga Baru : ");
                                    int hargaBaru = scanner.nextInt();

                                    System.out.println();

                                    System.out.println("Masukkan Stok Baru : ");
                                    int stokBaru = scanner.nextInt();

                                    System.out.println();

                                    dataMinuman.set(noMinuman - 1, new Minuman(namaBaru, hargaBaru, stokBaru));
                                    
                                    kondisiUbah = false;
                                } catch (Exception e) {
                                    System.out.println("Ada Kesalahan Format, Ulangi Masukkan Data");
                                    System.out.println("Contoh Format Harga = 100000");
                                    System.out.println("Contoh Format Stok = 100000");
                                }

                            }

                        } else {
                            System.out.println("Anda Salah Memasukkan angka");
                        }
                    } else {
                        System.out.println("Anda Salah Memasukkan angka");
                    }
                } else {
                    condition = false;
                }

            } catch (Exception e) {
                System.out.println("Ada Kesalahan, Ulangi!!");
                break;
            }
        }

    }

}
