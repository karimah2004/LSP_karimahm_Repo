package org.howard.edu.lsp.midterm.question3;
	
	import java.util.HashMap;
	import java.util.Map;
	
	/**
	 * Voting machine allows adding candidates, casting votes and determining election results
	 * 
	 */
	public class Voting {
	    private Map<String, Integer> votes;

	    /**
	     * Constructor
	     */
	    public Voting() {
	        votes = new HashMap<>();
	    }

	    /**
	     * Adds candidate to election
	     * @param name  name of candidate to vote for 
	     */
	    public void addCandidate(String name) {
	        votes.putIfAbsent(name, 0);
	    }
	    
	    /**
	     * Casts vote for a specific candidate 
	     * @param name   name of candidate being voted for 
	     * @return
	     */
	    public boolean castVote(String name) {
	        if (votes.containsKey(name)) {
	            votes.put(name, votes.get(name) + 1);
	            return true;
	        }
	        return false;
	    }
	    
	    /**
	     * Gets winner using highest number of votes. if a tie, first candidate encountered is the winner 
	     * @return   formatted string with winners name and total vote count 
	     */
	    public String getWinner() {
	        String winner = null;
	        int maxVotes = 0;
	        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
	            if (entry.getValue() > maxVotes) {
	                maxVotes = entry.getValue();
	                winner = entry.getKey();
	            }
	        }
	        return winner + " WINS with " + maxVotes + " votes!!";
	    }
	}


