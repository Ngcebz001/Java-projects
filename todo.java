package java_dev;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

class Frame extends JFrame{

    private TitleBar title;
    private List list;
    private Footer btnPanel;

    private JButton addTask;
    private JButton clearTasks;

    //Constructor
    Frame(){
        this.setSize(300, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        list = new List();
        btnPanel = new Footer();

        this.add(title, BorderLayout.NORTH);
        this.add(list, BorderLayout.CENTER);
        this.add(btnPanel,BorderLayout.SOUTH);

        addTask = btnPanel.getNewTask();
        clearTasks = btnPanel.getClearTasks();

        addListener();
    }

    public void addListener(){
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                Task task = new Task();
                list.add(task);
                list.updateNumbers();

                task.getComplete().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        task.changeState();
                        revalidate();
                    }
                });
                revalidate();
            }
        });
            clearTasks.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                list.removeCompleteTasks();
                repaint();
            }
            });
    }
}

class TitleBar extends JPanel{

    TitleBar(){
        this.setPreferredSize(new Dimension(400, 80));
        this.setBackground(Color.cyan);

        JLabel titleLabel = new JLabel("To Do List");
        titleLabel.setPreferredSize(new Dimension(200, 60));
        titleLabel.setFont(new Font("Sans-serif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleLabel);
    }
}

class Footer extends JPanel{
    private JButton addTask;
    private JButton clearTasks;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    Footer(){
        this.setPreferredSize(new Dimension(400,60));

        addTask = new JButton("Add New Task");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        clearTasks = new JButton("Clear Tasks");
        clearTasks.setBorder(emptyBorder);
        clearTasks.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        this.add(addTask);
        this.add(Box.createHorizontalStrut(20));
        this.add(clearTasks);

    }

    public JButton getNewTask(){
        return addTask;
    }
    public JButton getClearTasks(){
        return clearTasks;
    }
}

class Task extends JPanel{

    private JLabel index;
    private JTextField task;
    private JButton done;

    private boolean isComplete;
    Task(){

        isComplete = false;
        this.setPreferredSize(new Dimension(40,20));

        this.setLayout(new BorderLayout());

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20,20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index,BorderLayout.WEST);

        task = new JTextField("Enter New Task");
        task.setBorder(BorderFactory.createEmptyBorder());

        this.add(task, BorderLayout.CENTER);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(40,20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setFocusPainted(false);

        this.add(done, BorderLayout.EAST);
    }

    public JButton getComplete(){
        return done;
    }
    public void changeIndex(int index){
        this.index.setText(index+"");
        this.revalidate();
    }

    public boolean getState(){
        return isComplete;
    }
    public void changeState(){
        isComplete = true;
        this.setBackground(Color.CYAN);
        task.setBackground(Color.CYAN);
    }

}

class List extends JPanel{
    List(){
    GridLayout layout = new GridLayout(10, 1);
    layout.setVgap(5);
    
    this.setLayout(layout);

    }

    public void updateNumbers(){
        Component[] listItems = this.getComponents();

        for(int index = 0; index < listItems.length; index++){
            if(listItems[index] instanceof Task){
                ((Task)listItems[index]).changeIndex(index+1);
            }
        }
    }
    public void removeCompleteTasks(){
        for(Component c:getComponents()){
            if (c instanceof Task){
                if(((Task)c).getState()){
                    remove(c);
                    updateNumbers();
                }
            }
        }

    }

}

public class todo {

    public static void main(String[] args){
    Frame progFrame = new Frame();
    }
     
}