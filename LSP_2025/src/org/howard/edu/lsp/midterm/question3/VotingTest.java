package org.howard.edu.lsp.midterm.question3;

/**
 * Driver class to test the voting class
 */
public class VotingTest {

    public static void main(String[] args) {
        Voting vm = new Voting();
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);
        System.out.println("Winner: " + vm.getWinner());
    }
}
