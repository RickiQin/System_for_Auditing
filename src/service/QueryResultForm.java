/*
 * QueryResultForm.java
 *
 * Created on __DATE__, __TIME__
 */

package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import util.JdbcUtil;

/**
 * 
 * @author __USER__
 */
public class QueryResultForm extends javax.swing.JFrame {

	/** Creates new form QueryResultForm */
	public QueryResultForm() {
		initComponents();
		setLocationRelativeTo(null);

		String SSN = ManageComFrame.SSN;
		String sname = ManageComFrame.sname;

		stuSSNLabel.setText("SSN：" + SSN);
		stuNameLabel.setText("Name：" + sname);

		if (SSN != null) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet res = null;
			String sql = "select cname as CN,year as Y,semester as SM from course join attend on course.cid = attend.cid where SSN = ?";
			try {
				conn = JdbcUtil.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, SSN);
				res = ps.executeQuery();

				while (res.next()) {
					Object[] rowData = new Object[] { res.getString("CN"),
							res.getString("Y"), res.getString("SM") };
					((DefaultTableModel) (jTable1.getModel())).addRow(rowData);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(getParent(),
						"exception occurs: \r\n error message: " + e.getMessage(),
						"error message", 0);
			} finally {
				JdbcUtil.close(res, ps, conn);
			}
		}

	}


	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Query Result");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jLabel1.setText("浏览全部单位");

        jTable1.setBackground(new java.awt.Color(204, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("微软雅黑", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Name", "Registration Year", "Registration Semester"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new QueryResultForm().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}