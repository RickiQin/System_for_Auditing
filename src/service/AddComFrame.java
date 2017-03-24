/*
 * AddCourseFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.JdbcUtil;

/**
 * 
 * @author __USER__
 */
public class AddComFrame extends javax.swing.JFrame {

	/** Creates new form AddCourseFrame */
	public AddComFrame() {
		initComponents();
		setLocationRelativeTo(null);
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("添加单位");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel1.setText("添加一个新的单位");

        jTextField1.setForeground(java.awt.Color.gray);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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
                .addGap(79, 79, 79)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

	private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// 在 company 表中 添加 单位名
		String cname = jTextField1.getText().trim();
		if ("".equals(cname)) {
			JOptionPane.showMessageDialog(getParent(), "单位名不能为空",
					"warning message", 2);
		} 
                else {

			if (JOptionPane.showConfirmDialog(getParent(), "确定添加单位 【" + cname
					+ "】???", "YES", JOptionPane.YES_NO_OPTION, 3) == JOptionPane.YES_OPTION) {
                            
                            if (isExists(cname)) {
					JOptionPane.showMessageDialog(getParent(), "单位 【" + cname +"】 已经存在",
							"warning message", 2);
				} else {
                                
                                
				Connection conn = null;
				PreparedStatement ps = null;
				String sql = "insert into company(cname) values(?)";

				try {
					conn = JdbcUtil.getConn();
					conn.setAutoCommit(false);

					ps = conn.prepareStatement(sql);
					ps.setString(1, cname);
					ps.executeUpdate();

					conn.commit();
					JOptionPane.showMessageDialog(getParent(), "course 【" + cname
							+ "】 has been added successfully", "successful", 1);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(
							getParent(),
							"exception occurs: \r\n error message: "
									+ e.getMessage(), "error message", 0);
					try {
						conn.rollback(); // 事务回滚
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} finally {
					JdbcUtil.close(null, ps, conn);
				}
			}
		}
	}
}

        	public static boolean isExists(String cname){
		
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select * from course where cname = ?";
		
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			res = ps.executeQuery();
			
			if(res.next()){
				flag = true;
			}else{
				flag = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(res, ps, conn);
		}
		
		return flag;
	}
                
	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// 返回 按钮
		this.dispose();
		new MainFrame().setVisible(true);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddComFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}