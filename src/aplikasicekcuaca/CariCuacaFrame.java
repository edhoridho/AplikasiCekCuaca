/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasicekcuaca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

import javax.swing.JComboBox;


/**
 *
 * @author ACER A314
 */
public class CariCuacaFrame extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    /**
     * Creates new form CariCuacaFrame
     */

    public CariCuacaFrame() {
        initComponents();
        setupTableModel();
        loadFavorit();
        loadRiwayat();
    }
    
    private void setupTableModel() {
        tableModel = new DefaultTableModel(new String[]{"Kota", "Suhu (°C)", "Cuaca", "Kelembapan (%)", "Kecepatan Angin (m/s)"}, 0);
        tblRiwayatCuaca.setModel(tableModel);
    }
    
    private void loadFavorit() {
        try (BufferedReader reader = new BufferedReader(new FileReader("favorit.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cbbFavorit.addItem(line.trim());
            }
        } catch (IOException e) {
            // Abaikan jika file favorit.csv tidak ditemukan
        }
    }
    
    private void loadRiwayat() {
        try (BufferedReader reader = new BufferedReader(new FileReader("riwayat.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cbbRiwayat.addItem(line.trim());
            }
        } catch (IOException e) {
            // Abaikan jika file riwayat.csv tidak ditemukan
        }
    }
    
    private WeatherData fetchWeatherData(String lokasi) throws Exception {
        String apiKey = "108179319aba9408547cf0d3df4a540a";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + lokasi + "&units=metric&appid=" + apiKey;
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject json = new JSONObject(response.toString());
        double suhu = json.getJSONObject("main").getDouble("temp");
        String deskripsi = json.getJSONArray("weather").getJSONObject(0).getString("description");
        int kelembapan = json.getJSONObject("main").getInt("humidity");
        double angin = json.getJSONObject("wind").getDouble("speed");
        String iconCode = json.getJSONArray("weather").getJSONObject(0).getString("icon");
        String iconUrl = "https://openweathermap.org/img/wn/" + iconCode + "@2x.png";

        return new WeatherData(suhu, deskripsi, kelembapan, angin, iconUrl);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtLokasi = new javax.swing.JTextField();
        btnCekCuaca = new javax.swing.JButton();
        btnSimpanFavorit = new javax.swing.JButton();
        cbbRiwayat = new javax.swing.JComboBox<>();
        cbbFavorit = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblSuhu = new javax.swing.JLabel();
        lblDeskripsiCuaca = new javax.swing.JLabel();
        lblKelembapan = new javax.swing.JLabel();
        lblAngin = new javax.swing.JLabel();
        lblIconCuaca = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRiwayatCuaca = new javax.swing.JTable();
        btnEksporRiwayat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aplikasi Cek Cuaca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Daerah yang ingin anda cek disini"));

        btnCekCuaca.setText("Cek");
        btnCekCuaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekCuacaActionPerformed(evt);
            }
        });

        btnSimpanFavorit.setText("Favoritkan");
        btnSimpanFavorit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanFavoritActionPerformed(evt);
            }
        });

        jLabel7.setText("Riwayat");

        jLabel6.setText("Favorit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCekCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSimpanFavorit))
                            .addComponent(txtLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbFavorit, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbRiwayat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(94, 94, 94))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbFavorit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCekCuaca)
                    .addComponent(btnSimpanFavorit))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hasil Perkiraan Cuaca"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblSuhu.setText("Suhu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(lblSuhu, gridBagConstraints);

        lblDeskripsiCuaca.setText("DeskripsiCuaca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel3.add(lblDeskripsiCuaca, gridBagConstraints);

        lblKelembapan.setText("Kelembapan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel3.add(lblKelembapan, gridBagConstraints);

        lblAngin.setText("Angin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel3.add(lblAngin, gridBagConstraints);

        lblIconCuaca.setText("icon cuaca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel3.add(lblIconCuaca, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Riwayat Pengecekan"));

        tblRiwayatCuaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kota", "Suhu", "Cuaca", "Kelembapan", "Kecepatan angin"
            }
        ));
        jScrollPane1.setViewportView(tblRiwayatCuaca);

        btnEksporRiwayat.setText("Ekspor");
        btnEksporRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEksporRiwayatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEksporRiwayat)
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEksporRiwayat))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jScrollPane1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekCuacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekCuacaActionPerformed
        String lokasi = txtLokasi.getText().trim();
        if (lokasi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota!");
            return;
        }

        try {
            WeatherData weatherData = fetchWeatherData(lokasi);

            lblSuhu.setText("Suhu: " + weatherData.getTemperature() + "°C");
            lblDeskripsiCuaca.setText("Deskripsi: " + weatherData.getDescription());
            lblKelembapan.setText("Kelembapan: " + weatherData.getHumidity() + "%");
            lblAngin.setText("Angin: " + weatherData.getWindSpeed() + " m/s");
            lblIconCuaca.setIcon(new ImageIcon(new URL(weatherData.getIconImage())));

            if (!isComboBoxContains(cbbRiwayat, lokasi)) {
                cbbRiwayat.addItem(lokasi);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("riwayat.csv", true))) {
                    writer.write(lokasi + "\n");
                }
            }

            tableModel.addRow(new Object[]{lokasi, weatherData.getTemperature(), weatherData.getDescription(), weatherData.getHumidity(), weatherData.getWindSpeed()});
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data cuaca: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCekCuacaActionPerformed


    private boolean isComboBoxContains(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }
    
    private void btnSimpanFavoritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanFavoritActionPerformed
        String lokasi = txtLokasi.getText().trim();
        if (lokasi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan lokasi terlebih dahulu.");
            return;
        }

        if (!isComboBoxContains(cbbFavorit, lokasi)) {
            cbbFavorit.addItem(lokasi);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("favorit.csv", true))) {
                writer.write(lokasi + "\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan ke favorit: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lokasi sudah ada di favorit!");
        }
    }//GEN-LAST:event_btnSimpanFavoritActionPerformed

    private void btnEksporRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEksporRiwayatActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().endsWith(".csv")) {
                file = new File(file.getAbsolutePath() + ".csv");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        writer.write(tableModel.getValueAt(i, j).toString() + (j == tableModel.getColumnCount() - 1 ? "" : ","));
                    }
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(this, "Data berhasil diekspor!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal mengekspor data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEksporRiwayatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CariCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CariCuacaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCekCuaca;
    private javax.swing.JButton btnEksporRiwayat;
    private javax.swing.JButton btnSimpanFavorit;
    private javax.swing.JComboBox<String> cbbFavorit;
    private javax.swing.JComboBox<String> cbbRiwayat;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAngin;
    private javax.swing.JLabel lblDeskripsiCuaca;
    private javax.swing.JLabel lblIconCuaca;
    private javax.swing.JLabel lblKelembapan;
    private javax.swing.JLabel lblSuhu;
    private javax.swing.JTable tblRiwayatCuaca;
    private javax.swing.JTextField txtLokasi;
    // End of variables declaration//GEN-END:variables
}
