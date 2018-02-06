package fr.zankia.carsharing.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Window extends JFrame implements ItemListener, ChangeListener, ActionListener {
    private IMapView mapView;

    private JButton startButton, clearButton, dataButton, helpButton, quitButton, displaySavedSimuButton, deleteSavedSimuButton, newSavedSimuButton;
    private JComboBox savedSimuComboBox;
    private JCheckBox addClientCheckBox;
    private JSpinner stepSpinner, occupantSpinner, blockSizeSpinner, addClientSpinner, intervalSpinner;
    private JSlider probabilitySlider, speedSlider, costSlider;


    public Window(IMapView mapView) {
        this.mapView = mapView;

        startButton = new JButton("Start");
        clearButton = new JButton("Clear");
        dataButton = new JButton("Données");
        helpButton = new JButton("Instructions");
        quitButton = new JButton("Quitter");

        //Saving.setSavedSimuList();
        JLabel savedSimuLabel = new JLabel("Simulations enregistrées :");
        savedSimuComboBox = new JComboBox();
        savedSimuComboBox.addItem("Dernière simulation");
        //for(String s:Saving.savedSimuList)
        //    savedSimuComboBox.addItem(Saving.savedSimuNameOfSavedSimuString(s));
        savedSimuComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        savedSimuComboBox.addItemListener(this);
        displaySavedSimuButton = new JButton("Afficher");
        deleteSavedSimuButton = new JButton("Supprimer");
        newSavedSimuButton = new JButton("Enregistrer / Modifier");
        JPanel savedSimuLayout = new JPanel();
        savedSimuLayout.setLayout(new BoxLayout(savedSimuLayout,BoxLayout.PAGE_AXIS));
        savedSimuLayout.add(savedSimuLabel);
        savedSimuLayout.add(savedSimuComboBox);
        JPanel savedSimuButtonLayout = new JPanel();
        savedSimuButtonLayout.setLayout(new BoxLayout(savedSimuButtonLayout,BoxLayout.LINE_AXIS));
        savedSimuButtonLayout.add(displaySavedSimuButton);
        savedSimuButtonLayout.add(deleteSavedSimuButton);
        savedSimuButtonLayout.add(newSavedSimuButton);
        savedSimuButtonLayout.setAlignmentX(Component.LEFT_ALIGNMENT);
        savedSimuLayout.add(savedSimuButtonLayout);

        JLabel costLabel = new JLabel("Préférence pour la satisfaction du client :");
        costSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        costSlider.setMajorTickSpacing(50);
        costSlider.setMinorTickSpacing(10);
        costSlider.setPaintTicks(true);
        costSlider.setPaintLabels(true);
        costSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel costLayout = new JPanel();
        costLayout.setLayout(new BoxLayout(costLayout,BoxLayout.PAGE_AXIS));
        costLayout.add(costLabel);
        costLayout.add(costSlider);

        Dimension h1 = new Dimension(20,0);

        JLabel algorithmeLabel = new JLabel("Algorithme :");
        ButtonGroup algorithme = new ButtonGroup();
        JPanel algorithmeLayout = new JPanel();
        algorithmeLayout.setLayout(new BoxLayout(algorithmeLayout,BoxLayout.PAGE_AXIS));
        algorithmeLayout.add(algorithmeLabel);
        JRadioButton radioDeterministic = new JRadioButton("Déterministe");
        JRadioButton radioSimulatedAnnealing = new JRadioButton("Recuit simulé");
        JRadioButton radioGenetic = new JRadioButton("Genetique");
        algorithme.add(radioDeterministic);
        algorithme.add(radioSimulatedAnnealing);
        algorithme.add(radioGenetic);
        JLabel stepLabel = new JLabel("Nombre d'étapes : ");
        stepSpinner = new JSpinner(new SpinnerNumberModel(100, 1, 999999999, 1));
        JPanel stepLayout = new JPanel();
        stepLayout.setLayout(new BoxLayout(stepLayout,BoxLayout.LINE_AXIS));
        stepLayout.add(stepLabel);
        stepLayout.add(Box.createRigidArea(h1));
        stepLayout.add(stepSpinner);
        stepLayout.setAlignmentX(Component.LEFT_ALIGNMENT);
        algorithmeLayout.add(stepLayout);

        JLabel speedLabel = new JLabel("Vitesse de la simulation :");
        speedSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 10, 1);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        speedSlider.addChangeListener(this);
        JPanel speedLayout = new JPanel();
        speedLayout.setLayout(new BoxLayout(speedLayout,BoxLayout.PAGE_AXIS));
        speedLayout.add(speedLabel);
        speedLayout.add(speedSlider);

        JLabel occupantLabel = new JLabel("Capacités des voitures :");
        occupantSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 999, 1));
        JPanel occupantLayout = new JPanel();
        occupantLayout.setLayout(new BoxLayout(occupantLayout,BoxLayout.PAGE_AXIS));
        occupantLayout.add(occupantLabel);
        occupantLayout.add(occupantSpinner);
        occupantLayout.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel blockSizeLabel = new JLabel("Taille des blocks :");
        blockSizeSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 25, 1));
        blockSizeSpinner.addChangeListener(this);
        JPanel blockSizeLayout = new JPanel();
        blockSizeLayout.setLayout(new BoxLayout(blockSizeLayout,BoxLayout.PAGE_AXIS));
        blockSizeLayout.add(blockSizeLabel);
        blockSizeLayout.add(blockSizeSpinner);
        blockSizeLayout.setAlignmentX(Component.LEFT_ALIGNMENT);

        addClientCheckBox = new JCheckBox("Ajouter ");
        addClientCheckBox.addActionListener(this);
        addClientSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 999999, 1));
        addClientSpinner.setEnabled(false);
        JLabel addClientLabel = new JLabel(" clients à intervalle de ");
        intervalSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 999999, 1));
        intervalSpinner.setEnabled(false);
        JPanel addClientLayout = new JPanel();
        addClientLayout.setLayout(new BoxLayout(addClientLayout,BoxLayout.LINE_AXIS));
        addClientLayout.add(addClientCheckBox);
        addClientLayout.add(addClientSpinner);
        addClientLayout.add(addClientLabel);
        addClientLayout.add(intervalSpinner);
        addClientLayout.setAlignmentX(Component.LEFT_ALIGNMENT);
        probabilitySlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        probabilitySlider.setMajorTickSpacing(50);
        probabilitySlider.setMinorTickSpacing(10);
        probabilitySlider.setPaintTicks(true);
        probabilitySlider.setPaintLabels(true);
        probabilitySlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel leftColumn = new JPanel();
        leftColumn.setLayout(new BoxLayout(leftColumn,BoxLayout.PAGE_AXIS));
        Dimension v1 = new Dimension(0,30);
        leftColumn.add(savedSimuLayout);
        leftColumn.add(Box.createRigidArea(v1));
        leftColumn.add(algorithmeLayout);
        leftColumn.add(radioDeterministic);
        leftColumn.add(radioSimulatedAnnealing);
        leftColumn.add(radioGenetic);
        leftColumn.add(Box.createRigidArea(v1));
        leftColumn.add(costLayout);
        leftColumn.add(Box.createRigidArea(v1));
        leftColumn.add(addClientLayout);
        leftColumn.add(new JLabel("Avec probabilité d'utilisation du covoiturage dynamique :"));
        leftColumn.add(probabilitySlider);

        JPanel rightColumn = new JPanel();
        rightColumn.setLayout(new BoxLayout(rightColumn,BoxLayout.PAGE_AXIS));
        Dimension v2 = new Dimension(0,5);
        rightColumn.add(helpButton);
        rightColumn.add(Box.createRigidArea(v2));
        rightColumn.add(dataButton);
        rightColumn.add(Box.createRigidArea(v1));
        rightColumn.add(blockSizeLayout);
        rightColumn.add(Box.createRigidArea(v1));
        rightColumn.add(occupantLayout);
        rightColumn.add(Box.createRigidArea(v1));
        rightColumn.add(speedLayout);
        rightColumn.add(Box.createRigidArea(v1));
        rightColumn.add(startButton);
        rightColumn.add(Box.createRigidArea(v2));
        rightColumn.add(clearButton);
        rightColumn.add(Box.createRigidArea(v2));
        rightColumn.add(quitButton);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout());
        container.add(leftColumn);
        container.add((Component) mapView);
        container.add(rightColumn);
        setContentPane(container);

        //KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(app);
        setTitle("Car Sharing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
