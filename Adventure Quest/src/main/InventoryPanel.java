package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class InventoryPanel extends JPanel { // 定义 InventoryPanel 类，继承自 JPanel // Define the InventoryPanel class, extending JPanel.
    //Attributes 属性
    private DefaultListModel<BufferedImage> inventoryModel; // 定义 DefaultListModel，用于存储物品图像 // Define a DefaultListModel to store item images.
    private JList<BufferedImage> inventoryList; // 定义 JList，用于显示物品图像 // Define a JList for displaying item images.
    private final List<String> items; // 定义一个字符串列表，用于存储物品名称 // Define a string list to store item names.
    private final Map<String, List<BufferedImage>> itemImageMap; // 定义一个 Map，将物品名称映射到图像列表 // Define a Map to map item names to image lists.

    public InventoryPanel() { // 构造方法，用于初始化 InventoryPanel // Constructor to initialize the InventoryPanel.
        items = new ArrayList<>(); // 初始化物品名称列表 // Initialize the item name list.
        itemImageMap = new HashMap<>(); // 初始化物品映射表 // Initialize the item mapping table.

        this.setPreferredSize(new Dimension(150, -1)); // 设置面板的首选大小 // Set the preferred size of the panel.
        this.setLayout(new BorderLayout()); // 设置面板布局为 BorderLayout // Set the panel layout to BorderLayout.

        JLabel inventoryLabel = new JLabel("Inventory"); // 创建一个标签，用于显示 "Inventory" // Create a label to display "Inventory".
        inventoryLabel.setHorizontalAlignment(SwingConstants.CENTER); // 设置标签水平居中对齐 // Set the label to be horizontally centered.
        inventoryLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16)); // 设置标签字体和样式 // Set the label's font and style.
        inventoryLabel.setForeground(Color.WHITE); // 设置标签的前景色为白色 // Set the label's foreground color to white.

        inventoryModel = new DefaultListModel<>(); // 初始化 DefaultListModel // Initialize the DefaultListModel.
        inventoryList = new JList<>(inventoryModel); // 使用模型初始化 JList // Initialize the JList with the model.

        // 设置自定义单元格渲染器，用于显示图像 // Set a custom cell renderer for displaying images.
        inventoryList.setCellRenderer(new ImageCellRenderer());

        JScrollPane scrollPane = new JScrollPane(inventoryList); // 创建滚动面板以包含 JList // Create a scroll pane to contain the JList.

        // 设置面板和列表的背景颜色 // Set background colors for the panel and list.
        this.setBackground(Color.BLACK); // 设置面板背景为黑色 // Set the panel background to black.
        inventoryList.setBackground(Color.GRAY); // 设置列表背景为灰色 // Set the list background to gray.

        this.add(inventoryLabel, BorderLayout.NORTH); // 添加标签到面板的北部 // Add the label to the top of the panel.
        this.add(scrollPane, BorderLayout.CENTER); // 添加滚动面板到面板的中心 // Add the scroll pane to the center of the panel.
    }

    public List<String> getItems() { // 获取库存物品名称列表 // Get the list of item names in the inventory.
        return items;
    }

    public void addItemToInventory(BufferedImage itemImage, String itemName) { // 添加物品图像和名称到库存的方法 // Method to add an item image and name to the inventory.
        inventoryModel.addElement(itemImage); // 将物品图像添加到模型 // Add the item image to the model.
        items.add(itemName); // 将物品名称添加到列表 // Add the item name to the list.
        itemImageMap.computeIfAbsent(itemName, k -> new ArrayList<>()).add(itemImage); // 将物品名称映射到图像列表 // Map the item name to the image list.
    }

    public void removeItem(String itemName) { // 从库存中移除物品的方法 // Method to remove an item from the inventory.
        items.remove(itemName); // 从名称列表中移除物品名称的第一次出现 // Remove the first occurrence of the item name from the list.
        List<BufferedImage> images = itemImageMap.get(itemName); // 获取物品名称对应的图像列表 // Get the image list corresponding to the item name.
        if (images != null && !images.isEmpty()) { // 如果图像列表不为空 // If the image list is not empty.
            BufferedImage itemImage = images.remove(0); // 移除图像列表的第一个图像 // Remove the first image from the list.
            inventoryModel.removeElement(itemImage); // 从模型中移除图像 // Remove the image from the model.
            if (images.isEmpty()) { // 如果图像列表为空，移除名称映射 // If the image list is empty, remove the name mapping.
                itemImageMap.remove(itemName);
            }
        }
        revalidate(); // 重新验证面板布局 // Revalidate the panel's layout.
        repaint(); // 重绘面板 // Repaint the panel.
    }

    // 自定义单元格渲染器，用于显示列表中的图像 // Custom cell renderer for displaying images in the list.
    private static class ImageCellRenderer extends JLabel implements ListCellRenderer<BufferedImage> {
        public ImageCellRenderer() { // 构造方法 // Constructor.
            setOpaque(true); // 设置组件为不透明 // Set the component to be opaque.
            setHorizontalAlignment(CENTER); // 设置水平居中对齐 // Set horizontal alignment to center.
            setVerticalAlignment(CENTER); // 设置垂直居中对齐 // Set vertical alignment to center.
        }

        @Override
        public Component getListCellRendererComponent(
                JList<? extends BufferedImage> list, // JList 对象 // JList object.
                BufferedImage value, // 当前单元格的值 // Current cell value.
                int index, // 当前单元格的索引 // Current cell index.
                boolean isSelected, // 当前单元格是否被选中 // Whether the cell is selected.
                boolean cellHasFocus // 当前单元格是否有焦点 // Whether the cell has focus.
        ) {
            if (value != null) { // 如果值不为空 // If the value is not null.
                setIcon(new ImageIcon(value)); // 设置图像图标 // Set the image icon.
            } else {
                setIcon(null); // 如果值为空，不显示图标 // If the value is null, don't display an icon.
            }

            // 设置选中和未选中的背景色和前景色 // Set background and foreground colors for selected and unselected states.
            if (isSelected) {
                setBackground(list.getSelectionBackground()); // 设置背景色为选中背景色 // Set the background to the selection background color.
                setForeground(list.getSelectionForeground()); // 设置前景色为选中前景色 // Set the foreground to the selection foreground color.
            } else {
                setBackground(list.getBackground()); // 设置背景色为默认背景色 // Set the background to the default background color.
                setForeground(list.getForeground()); // 设置前景色为默认前景色 // Set the foreground to the default foreground color.
            }

            return this; // 返回渲染的组件 // Return the rendered component.
        }
    }
}
