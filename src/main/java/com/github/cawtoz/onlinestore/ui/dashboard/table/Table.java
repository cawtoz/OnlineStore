package com.github.cawtoz.onlinestore.ui.dashboard.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import lombok.Getter;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@Getter
public abstract class Table extends JTable {

    private final String name;
    private JPanel jPanel;

    public Table(String name) {
        this.name = name;
        initializeTable();
    }

    private void initializeTable() {

        setSelectionBackground(new Color(106, 125, 234, 255));
        setModel(new DefaultTableModel(getRows(), getColums()));
        setColumnsWidth();

        JTableHeader tableHeader = getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);
        tableHeader.setForeground(new Color(141, 3, 197));
        tableHeader.setFont(new Font(getFont().getName(), Font.BOLD, getFont().getSize()));

        setDefaultEditor(Object.class, null);
        setBackground(new Color(245, 245, 245));
        setDefaultRenderer(Object.class, new AlternatingRowRenderer());
    }

    private void setColumnsWidth() {
        int numColumns = getColumnModel().getColumnCount();
        for (int i = 0; i < numColumns; i++) {
            getColumnModel().getColumn(i).setPreferredWidth(getPreferredColumnWidth(i));
        }
    }

    public Table putInContainer(Container container, int x, int y, int width, int height) {
        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setBounds(-1, -1, width + 2,height + 2);
        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(x, y, width, height);
        jPanel.add(scrollPane);
        container.add(jPanel);
        jPanel.setVisible(true);
        return this;
    }

    private static class AlternatingRowRenderer extends DefaultTableCellRenderer {
        private final Color oddRowColor = new Color(245, 245, 245);
        private final Color evenRowColor = new Color(141, 3, 197, 29);

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {
                Color bgColor = (row % 2 == 0) ? evenRowColor : oddRowColor;
                rendererComponent.setBackground(bgColor);
            }

            return rendererComponent;
        }
    }

    protected abstract String[] getColums();
    protected abstract Object[][] getRows();
    protected abstract int getPreferredColumnWidth(int columnIndex);

}
