package org.example;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;


public class JFrame extends javax.swing.JFrame {

    DefaultTreeModel model;

    public JFrame() {
        initComponents();
        ArrayList<Person> p = getPersons();
        Load(p);
    }

    DefaultMutableTreeNode persons = new DefaultMutableTreeNode("Persons");

    public ArrayList<Person> getPersons() {
        Data_manipulation dm = new Data_manipulation();
        Excel_names provider = new Excel_names();

        provider.run_for_names("/Users/danielaarkind/Desktop/second_names.xlsx");
        provider.run_for_courses("/Users/danielaarkind/Desktop/courses.xlsx");

        return dm.Data_manipulation(provider);
    }

    public void Load(ArrayList<Person> stuff) {

        DefaultMutableTreeNode students = new DefaultMutableTreeNode("Students");
        DefaultMutableTreeNode professors = new DefaultMutableTreeNode("Professors");

        for (Person person : stuff) {
            if (person.getClass() == Professor.class) {
                String node = person.getLastname() + " " + person.getFirstname() + " " + person.getMiddlename();
                DefaultMutableTreeNode prof = new DefaultMutableTreeNode(node);
                ArrayList<Book> books = person.getBooks();
                for (Book book : books) {
                    prof.add(new DefaultMutableTreeNode(book.getTitle()));
                }
                professors.add(prof);
            } else {
                String node = person.getLastname() + " " + person.getFirstname() + " " + person.getMiddlename();
                DefaultMutableTreeNode prof = new DefaultMutableTreeNode(node);
                ArrayList<Book> books = person.getBooks();
                for (Book book : books) {
                    prof.add(new DefaultMutableTreeNode(book.getTitle()));
                }
                students.add(prof);
            }
        }
        persons.add(students);
        persons.add(professors);
        model = (DefaultTreeModel) jTree1.getModel();
        model.setRoot(persons);
        jTree1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
}