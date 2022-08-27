/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.view.authenticated.event.stage;

import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tiket.controller.EventController;
import tiket.controller.EventStagePerformanceController;
import tiket.controller.PerformanceController;
import tiket.controller.StageController;
import tiket.helper.DTHelper;
import tiket.model.Event;
import tiket.model.EventStagePerformance;
import tiket.model.Stage;

/**
 *
 * @author fkrfd
 */
public class PerformanceForm extends javax.swing.JFrame {

    private Event event = null;

    private Stage stage = null;

    private final EventController eventController = new EventController();

    private final StageController stageController = new StageController();
    
    private final PerformanceController pController = new PerformanceController();

    private final EventStagePerformanceController performanceController = new EventStagePerformanceController();

    private DefaultTableModel tableModel;

    private DefaultComboBoxModel comboBoxModel;
    
    private final DTHelper dtHelper = new DTHelper();

    /**
     * Creates new form PerformanceForm
     */
    public PerformanceForm(int eventId, int stageId) {
        initComponents();

        event = eventController.get(eventId);
        stage = stageController.get(stageId);

        setPerformanceTable();
        setPerformanceList();
        resetInput();
    }
    
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    private void timeOnly(KeyEvent event) {
        char c = event.getKeyChar();

        if (!(Character.isDigit(c)) && c != ':') {
            event.consume();
        }
    }

    private void setPerformanceTable() {
        Object[] tableHeader = {"ID Performance", "Nama Performance", "Waktu Mulai", "Nama Event", "Nama Stage", "Nomor Stage"};
        tableModel = new DefaultTableModel(null, tableHeader);
        tblPerformance.setModel(tableModel);

        populateTable();
    }

    private void populateTable() {
        List<EventStagePerformance> performances = performanceController.getAll(event.getId(), stage.getId());

        performances.forEach((performance) -> {
            Object[] data = {
                performance.getId(),
                performance.getPerformance().getName(),
                performance.getStartedAt(),
                performance.getEvent().getName(),
                performance.getStage().getName(),
                performance.getStage().getNumber()
            };

            tableModel.addRow(data);
        });
    }

    private void resetInput() {
        txtId.setText("");
        txtStartedDate.setDate(new Date());
        txtStartedTime.setText("");
        
        btnAdd.setEnabled(true);
    }

    private void setPerformanceList() {
        comboBoxModel = new DefaultComboBoxModel();
        
        cbId.setModel(comboBoxModel);

        populatePerformanceList();
    }

    private void populatePerformanceList() {
        List<EventStagePerformance> performances = performanceController.getAll(event.getId(), stage.getId());

        performances.forEach((performance) -> {
            comboBoxModel.addElement(performance.getPerformance().getId() + " " + performance.getPerformance().getName());
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerformance = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbId = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblPerformanceName = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtStartedDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtStartedTime = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();

        txtId.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1366, 768));

        jLabel10.setText("Dashboard >");

        jLabel1.setText("Manajemen Event >");

        jLabel2.setText("Manajemen Stage >");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Manajemen Performance");

        tblPerformance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPerformance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPerformanceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPerformance);

        jLabel4.setText("Pilih ID Performance");

        cbId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbIdMouseClicked(evt);
            }
        });

        jLabel5.setText("Nama Performance :");

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel6.setText("Tanggal Mulai");

        txtStartedDate.setDateFormatString("yyyy-MM-dd");
        txtStartedDate.setMinSelectableDate(new Date());

        jLabel7.setText("Jam Mulai");

        txtStartedTime.setColumns(20);
        txtStartedTime.setRows(1);
        txtStartedTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStartedTimeKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtStartedTime);

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Contoh: 00:00");

        btnEdit.setText("Ubah");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStartedDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(cbId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPerformanceName))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblPerformanceName))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStartedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPerformanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPerformanceMouseClicked
        int row = tblPerformance.getSelectedRow();

        String id = tableModel.getValueAt(row, 0).toString();
        
        txtId.setText(id);
        
        btnAdd.setEnabled(false);
    }//GEN-LAST:event_tblPerformanceMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String temp = cbId.getSelectedItem().toString();
        String[] tempArr = temp.split(" ");
        int performanceId = new Integer(tempArr[0]);
        
        boolean response = performanceController.insert(event.getId(), stage.getId(), performanceId, txtStartedDate.getDate(), txtStartedTime.getText());
        
        if (!response) {
            showMessage("Terjadi kesalahan saat menyimpan data, silahkan coba lagi");
            return;
        }

        showMessage("Berhasil menyimpan data");
        setPerformanceTable();
        resetInput();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtId.getText().equals("")) {
            showMessage("Anda harus memilih data terlebih dahulu");
            return;
        }

        boolean response = performanceController.delete(new Integer(txtId.getText()));

        if (!response) {
            showMessage("Terjadi kesalahan saat menghapus data, silahkan coba lagi");
            return;
        }

        showMessage("Berhasil menghapus data");
        setPerformanceTable();
        resetInput();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIdMouseClicked
        setPerformanceList();
    }//GEN-LAST:event_cbIdMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetInput();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtStartedTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStartedTimeKeyTyped
        timeOnly(evt);
    }//GEN-LAST:event_txtStartedTimeKeyTyped

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtId.getText().equals("")) {
            showMessage("Anda harus memilih data terlebih dahulu");
            return;
        }

        String startedDate = dtHelper.formatMysqlDate(txtStartedDate.getDate());

        String startedAt = startedDate + " " + txtStartedTime.getText();

        EventStagePerformance performance = new EventStagePerformance();
        performance.setId(new Integer(txtId.getText()));
        performance.setEvent(eventController.get(event.getId()));
        performance.setStage(stageController.get(stage.getId()));
        performance.setPerformance(pController.get(new Integer(txtId.getText())));
        performance.setStartedAt(startedAt);

        boolean response = performanceController.update(performance);

        if (!response) {
            showMessage("Terjadi kesalahan saat mengubah data, silahkan coba lagi");
            return;
        }

        showMessage("Berhasil mengubah data");
        setPerformanceTable();
        resetInput();
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(PerformanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerformanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerformanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerformanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerformanceForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblPerformanceName;
    private javax.swing.JTable tblPerformance;
    private javax.swing.JTextField txtId;
    private com.toedter.calendar.JDateChooser txtStartedDate;
    private javax.swing.JTextArea txtStartedTime;
    // End of variables declaration//GEN-END:variables
}
