/*
 * RegisterCourseFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
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
public class RegisterCourseFrame extends javax.swing.JFrame {

	/** Creates new form RegisterCourseFrame */
	public RegisterCourseFrame() {
		initComponents();
		setLocationRelativeTo(null);

		Font font = new Font("Calibri", Font.BOLD, 13);

		courseNameLabel.setFont(font);
		courseNameLabel.setForeground(Color.red);
		studentName.setFont(font);
		studentName.setForeground(Color.red);

		Connection conn = null;
		PreparedStatement psQueCou = null;
		PreparedStatement psQueStu = null;
		ResultSet res = null;
		String sqlQueCou = "select cid as CID from course";
		String sqlQueStu = "select SSN as SSN from student";

		try {
			conn = JdbcUtil.getConn();

			psQueCou = conn.prepareStatement(sqlQueCou);
			psQueStu = conn.prepareStatement(sqlQueStu);

			res = psQueCou.executeQuery();

			while (res.next()) {
				courseCodeJComboBox.addItem(res.getString("CID"));
			}

			res = psQueStu.executeQuery();

			while (res.next()) {
				studentSSNJComboBox.addItem(res.getString("SSN"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(getParent(),
					"exception occurs when querying: \r\n error message: " + e.getMessage(),
					"error message", 0);
		} finally {
			JdbcUtil.close(res, psQueCou, conn);
			JdbcUtil.close(res, psQueStu, conn);
		}
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        courseCodeJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        studentSSNJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        registerYearJComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        sememsterJComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        courseNameLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        studentNameLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        studentName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register a course");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel1.setText("Register  a  course");

        jLabel2.setText("Course Code");

        courseCodeJComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        courseCodeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---select courseID---" }));
        courseCodeJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                courseCodeJComboBoxItemStateChanged(evt);
            }
        });
        courseCodeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCodeJComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Student SSN");

        studentSSNJComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        studentSSNJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---select studentID---" }));
        studentSSNJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentSSNJComboBoxItemStateChanged(evt);
            }
        });
        studentSSNJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSSNJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("register Year");

        registerYearJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013" }));
        registerYearJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerYearJComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Semester");

        sememsterJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "spring", "fall" }));

        jLabel6.setText("Course Name");

        jLabel7.setText("Student Name");

        registerButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
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
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentName)
                            .addComponent(registerYearJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sememsterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentSSNJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentNameLabel)
                            .addComponent(courseNameLabel)
                            .addComponent(courseCodeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(registerButton)
                        .addGap(38, 38, 38)
                        .addComponent(backButton)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(courseCodeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseNameLabel)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentSSNJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameLabel)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(studentName))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(registerYearJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sememsterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(registerButton))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(studentNameLabel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void courseCodeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCodeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseCodeJComboBoxActionPerformed

    private void studentSSNJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSSNJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSSNJComboBoxActionPerformed

    private void registerYearJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerYearJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerYearJComboBoxActionPerformed

	private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// 注册 按钮
		String SSN = studentSSNJComboBox.getSelectedItem().toString();
		String cid = courseCodeJComboBox.getSelectedItem().toString();
		String year = registerYearJComboBox.getSelectedItem().toString();
		String semester = sememsterJComboBox.getSelectedItem().toString();

		String sname = studentName.getText();
		String cname = courseNameLabel.getText();

		if ("---select courseID---".equals(cid)) {
			JOptionPane.showMessageDialog(getParent(), "please select courseID first",
					"warning message", 2);
		} else {
			if ("---select studentID---".equals(SSN)) {
				JOptionPane.showMessageDialog(getParent(), "please select studentID first",
						"warning message", 2);
			} else {

				if (JOptionPane.showConfirmDialog(getParent(),
						"register course \r\n{\r\nstudent name：" + sname + "\r\ncourse name：" + cname
								+ "\r\nregister year：" + year + "\r\nsemester：" + semester
								+ "\r\n} ???", "YES",
						JOptionPane.YES_NO_OPTION, 3) == JOptionPane.YES_OPTION) {

					Connection conn = null;
					PreparedStatement ps = null;
					String sql = "insert into attend values(?,?,?,?)";

					try {
						conn = JdbcUtil.getConn();
						conn.setAutoCommit(false);

						ps = conn.prepareStatement(sql);
						ps.setInt(1, Integer.parseInt(SSN));
						ps.setInt(2, Integer.parseInt(cid));
						ps.setString(3, year);
						ps.setString(4, semester);
						ps.executeUpdate();

						conn.commit();

						JOptionPane.showMessageDialog(getParent(),
								"Course has been registered successfully", "successful", 1);

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(
								getParent(),
								"exception occurs: \r\n error message: "
										+ e.getMessage(), "error message", 0);
						try {
							conn.rollback();
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

	private void studentSSNJComboBoxItemStateChanged(
			java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		// studentNameLabel change事件
		String SSN = studentSSNJComboBox.getSelectedItem().toString();

		if (evt.getStateChange() == ItemEvent.SELECTED) {
			if ("---select studentID---".equals(SSN)) {

				studentName.setText("");

			} else {

				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet res = null;
				String sql = "select sname as SN from student where SSN = ?";

				try {
					conn = JdbcUtil.getConn();

					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(SSN));
					res = ps.executeQuery();

					res.next();
					studentName.setText(res.getString("SN"));

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane
							.showMessageDialog(
									getParent(),
									"exception occurs when querying: \r\n error message: "
											+ e.getMessage(), "error message",
									0);
				} finally {
					JdbcUtil.close(res, ps, conn);
				}
			}
		}
	}

	private void courseCodeJComboBoxItemStateChanged(
			java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		// courseCodeJComboBox change事件
		String cid = courseCodeJComboBox.getSelectedItem().toString();

		if (evt.getStateChange() == ItemEvent.SELECTED) {
			if ("---select courseID---".equals(cid)) {
				courseNameLabel.setText("");
			} else {

				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet res = null;
				String sql = "select cname as CN from course where cid = ?";

				try {
					conn = JdbcUtil.getConn();

					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(cid));
					res = ps.executeQuery();

					res.next();
					courseNameLabel.setText(res.getString("CN"));

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane
							.showMessageDialog(
									getParent(),
									"exception occurs when querying: \r\n error message: "
											+ e.getMessage(), "error message",
									0);
				} finally {
					JdbcUtil.close(res, ps, conn);
				}
			}
		}

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
				new RegisterCourseFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox courseCodeJComboBox;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton registerButton;
    private javax.swing.JComboBox registerYearJComboBox;
    private javax.swing.JComboBox sememsterJComboBox;
    private javax.swing.JLabel studentName;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JComboBox studentSSNJComboBox;
    // End of variables declaration//GEN-END:variables

}