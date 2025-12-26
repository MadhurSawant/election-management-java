package Testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalBallotPage {
    private JFrame frame;
    private JPanel ballotPanel;
    private JPanel candidatePanel;
    private JButton submitButton;
    private JLabel resultLabel;

    private String[] candidates = {"Candidate 1", "Candidate 2", "Candidate 3"};
    private boolean[] votes = new boolean[candidates.length];

    public DigitalBallotPage() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Digital Ballot Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballotPanel = new JPanel();
        ballotPanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Digital Ballot Page");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        ballotPanel.add(title, BorderLayout.NORTH);

        JLabel instructions = new JLabel("Select your preferred candidate:");
        instructions.setFont(new Font("Arial", Font.PLAIN, 18));
        ballotPanel.add(instructions, BorderLayout.CENTER);

        candidatePanel = new JPanel();
        candidatePanel.setLayout(new GridLayout(candidates.length, 1));

        for (int i = 0; i < 5; i++) {
            JCheckBox checkBox = new JCheckBox(candidates[i]);
            checkBox.addActionListener(new VoteListener(i));
            candidatePanel.add(checkBox);
        }

        ballotPanel.add(candidatePanel, BorderLayout.SOUTH);

        submitButton = new JButton("Submit Vote");
        submitButton.addActionListener(new SubmitListener());
        ballotPanel.add(submitButton, BorderLayout.SOUTH);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ballotPanel.add(resultLabel, BorderLayout.SOUTH);

        frame.getContentPane().add(ballotPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private class VoteListener implements ActionListener {
        private int candidateIndex;

        public VoteListener(int candidateIndex) {
            this.candidateIndex = candidateIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            votes[candidateIndex] = checkBox.isSelected();
        }
    }

    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int winnerIndex = -1;
            int maxVotes = 0;

            for (int i = 0; i < votes.length; i++) {
                if (votes[i]) {
                    int count = countVotes(i);
                    if (count > maxVotes) {
                        maxVotes = count;
                        winnerIndex = i;
                    }
                }
            }

            if (winnerIndex != -1) {
                resultLabel.setText("The winner is: " + candidates[winnerIndex]);
            } else {
                resultLabel.setText("No winner");
            }
        }

        private int countVotes(int candidateIndex) {
            int count = 0;
            for (boolean vote : votes) {
                if (vote) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DigitalBallotPage();
            }
        });
    }
}