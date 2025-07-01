package com.ui;

import com.controller.TaskController;
import com.dto.TaskDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoAppUI extends JFrame {
    private DefaultListModel<String> taskModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(taskModel);
    private JTextField taskField = new JTextField(20);
    private TaskController controller = new TaskController();

    public ToDoAppUI() {
        setTitle("ToDo List App");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        add(inputPanel, BorderLayout.NORTH);

        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Event handling
        addButton.addActionListener(e -> {
            String taskText = taskField.getText();
            if (!taskText.isEmpty()) {
                controller.addTask(taskText);
                refreshTaskList();
                taskField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                controller.deleteTask(selected);
                refreshTaskList(); // Refresh the UI after deletion
            } else {
                JOptionPane.showMessageDialog(this, "Please select a task to delete.");
            }
        });

    }

    private void refreshTaskList() {
        taskModel.clear();
        for (TaskDTO task : controller.getTasks()) {
            taskModel.addElement(task.getTask());
        }
    }
}

