/*
 * CheckRegistration.java
 *
 * Created on __DATE__, __TIME__
 */

package service;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.JdbcUtil;

/**
 *
 * @author  __USER__
 */
public class ManageComFrame extends javax.swing.JFrame {

	public static String SSN;
	public static String sname;
	
	/** Creates new form CheckRegistration */
	public ManageComFrame() {
		initComponents();
		setLocationRelativeTo(null);
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        queryButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Check Registration");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel1.setText("Check  student  Registration");

        jLabel2.setText("according");

        jLabel3.setText("to check registration");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("SSN");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Name");

        jLabel4.setText("Enter SSN&Name");

        queryButton.setText("Submit");
        queryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryButtonActionPerformed(evt);
            }
        });

        backButton.setText("Cancel");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(queryButton)
                        .addGap(51, 51, 51)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

	private void queryButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// 查询按钮
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		if(jRadioButton1.isSelected()){
			
			String SSN = jTextField1.getText();
			String sql = "select sname as SN from student join attend on student.SSN = attend.SSN where student.SSN = ?";
			
			try {
				conn = JdbcUtil.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, SSN);
				res = ps.executeQuery();

				if(res.next()){
					
					this.SSN = SSN;
					this.sname = res.getString("SN");
					new QueryResultForm().setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(
							getParent(),
							"There is no student whose SSN is 【"+SSN+"】 or there're no courses registered this student","error message", 0);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(
						getParent(),
						"exception occurs: \r\n error message: "
								+ e.getMessage(), "error message", 0);
			} finally {
				JdbcUtil.close(res, ps, conn);
			}
		}
		
		if(jRadioButton2.isSelected()){
			
			String sname = jTextField1.getText();
			String sql = "select student.SSN as SSN from student join attend on student.SSN = attend.SSN where sname = ?";
			
			try {
				conn = JdbcUtil.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, sname);
				res = ps.executeQuery();

				if(res.next()){
					
					this.SSN = res.getString("SSN");
					this.sname = sname;
					
					new QueryResultForm().setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(
							getParent(),
							"There is no student called 【"+sname+"】 or there're no courses registered by 【"+sname+"】","error message", 0);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(
						getParent(),
						"exception occurs: \r\n error message: "
								+ e.getMessage(), "error message", 0);
			} finally {
				JdbcUtil.close(res, ps, conn);
			}
			
		}
	}

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.dispose();
		new MainFrame().setVisible(true);
	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ManageComFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton queryButton;
    // End of variables declaration//GEN-END:variables

}