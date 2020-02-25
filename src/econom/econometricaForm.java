/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econom;

// import JPAControllers 
// https://www.omniprogrammer.com/?p=383
//
import JPAControllers.CountryJpaController;
import JPAControllers.CountryDatasetJpaController;
import JPAControllers.CountryDataJpaController;

// import entities
import econom.entities.Country;
import econom.entities.CountryData;
import econom.entities.CountryDataset;

// related imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author kmt
 */
public class econometricaForm extends javax.swing.JFrame {

    /**
     * Creates new form econometricaForm
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("econometricaPU");
    EntityManager em = emf.createEntityManager();
    CountryJpaController cjc = new CountryJpaController(emf);
    CountryDatasetJpaController cdsjc = new CountryDatasetJpaController(emf);
    CountryDataJpaController cdjc = new CountryDataJpaController(emf);

    
    
    String gdpStart = "https://www.quandl.com/api/v3/datasets/WWDI/";
    String gdpEnd = "_NY_GDP_MKTP_CN.json?api_key=";
    
    String oilStart = "https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_";
    String oilEnd = ".json?api_key=";
    
    String apiKey = "946RzpzmS4GxJKhdLuJ7";
    
    String fileLocation = "C:\\Users\\kmt\\Documents\\MEGA\\Coding\\Java\\econom\\iso-countries.csv";

    
    public econometricaForm() throws Exception {
        initComponents();
        csvToDatabase();

    }

    public void csvToDatabase() throws Exception {

        List<Country> countries = readCSV(fileLocation);

        if (cjc.findCountryEntities().isEmpty()) {

            // Insert instances of Country to database 
            for (Country c : countries) {
                Country nc = new Country();
                nc.setIsoCode(c.getIsoCode());
                nc.setName(c.getName());
                cjc.create(nc);
            }
        }

        //Create ComboBoxModel to list countries in econometricaForm combobox button.
        //https://www.codejava.net/java-se/swing/jcombobox-basic-tutorial-and-examples
        //
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Country c : countries) {
            model.addElement(c.getName());
        }
        countriesComboBox.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        econometricaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("econometricaPU").createEntityManager();
        countryQuery = java.beans.Beans.isDesignTime() ? null : econometricaPUEntityManager.createQuery("SELECT c FROM Country c");
        countryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : countryQuery.getResultList();
        countryQuery1 = java.beans.Beans.isDesignTime() ? null : econometricaPUEntityManager.createQuery("SELECT c FROM Country c");
        countryList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : countryQuery1.getResultList();
        countriesComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        fetchDataButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        oilStartDate = new javax.swing.JLabel();
        oilEndDate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        gdpStartDate = new javax.swing.JLabel();
        gdpEndDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        oilTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        gdpTable = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        plotButton = new javax.swing.JButton();
        deleteAllButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        countriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        countriesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countriesComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Country:");

        fetchDataButton.setText("Fetch Data");
        fetchDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchDataButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("OIL DATA");

        jLabel3.setText("Dataset Name");

        jLabel4.setText("jLabel4");

        jLabel5.setText("GDP DATA");

        jLabel6.setText("Dataset Name");

        jLabel7.setText("jLabel7");

        jLabel8.setText("Availiable Timespan:");

        jLabel9.setText("Availiable Timespan:");

        jLabel10.setText("Start Date");

        jLabel11.setText("End Date");

        oilStartDate.setText("jLabel12");

        oilEndDate.setText("jLabel13");

        jLabel14.setText("Start Date");

        jLabel15.setText("End Date");

        gdpStartDate.setText("jLabel16");

        gdpEndDate.setText("jLabel17");

        oilTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Year", "Value"
            }
        ));
        jScrollPane1.setViewportView(oilTable);

        gdpTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Year", "Value"
            }
        ));
        jScrollPane2.setViewportView(gdpTable);

        jCheckBox1.setText("Already Saved To Database");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        plotButton.setText("Plot");
        plotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotButtonActionPerformed(evt);
            }
        });

        deleteAllButton.setText("Delete ALL");
        deleteAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(oilEndDate)
                                            .addComponent(oilStartDate))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(gdpEndDate)
                                            .addComponent(gdpStartDate)))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(110, 110, 110))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(plotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(countriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fetchDataButton)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fetchDataButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(oilStartDate)
                    .addComponent(jLabel14)
                    .addComponent(gdpStartDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(oilEndDate)
                    .addComponent(jLabel15)
                    .addComponent(gdpEndDate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(saveButton)
                    .addComponent(plotButton)
                    .addComponent(deleteAllButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void countriesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countriesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countriesComboBoxActionPerformed

    private void fetchDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchDataButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fetchDataButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void plotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotButtonActionPerformed

    private void deleteAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteAllButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(econometricaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(econometricaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(econometricaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(econometricaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new econometricaForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(econometricaForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> countriesComboBox;
    private java.util.List<econom.entities.Country> countryList;
    private java.util.List<econom.entities.Country> countryList1;
    private javax.persistence.Query countryQuery;
    private javax.persistence.Query countryQuery1;
    private javax.swing.JButton deleteAllButton;
    private javax.persistence.EntityManager econometricaPUEntityManager;
    private javax.swing.JButton fetchDataButton;
    private javax.swing.JLabel gdpEndDate;
    private javax.swing.JLabel gdpStartDate;
    private javax.swing.JTable gdpTable;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel oilEndDate;
    private javax.swing.JLabel oilStartDate;
    private javax.swing.JTable oilTable;
    private javax.swing.JButton plotButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    //
    // METHODS
    // 
    
    
    // Reading CSV file, creating a list of instances of class Country.  
    private static List<Country> readCSV(String fileLocation) throws FileNotFoundException, IOException {

        List<Country> countries = new ArrayList<>();

        File csvFile = new File(fileLocation);

        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFile))) {
            csvReader.readLine();
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                // Create object country calling constructor.
                Country c = new Country(data[2], data[0]);
                countries.add(c);
            }
        }

        return countries;
    }

}
