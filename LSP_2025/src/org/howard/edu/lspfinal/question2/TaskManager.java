package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Represents a single task with a unique name, priority, and status.
 */
class Task {
	private String name;
	private int priority;
	private String status;

	/**
	 * Constructs a new Task.
	 * 
	 * @param name     the unique name of the task
	 * @param priority the task's priority (lower number = higher priority)
	 * @param status   the task's current status
	 */
	public Task(String name, int priority, String status) {
		this.name = name;
		this.priority = priority;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
	}
}

/**
 * Exception thrown when a task with a duplicate name is added.
 */
class DuplicateTaskException extends Exception {
	private static final long serialVersionUID = 1L; // i googled because i ran into a warning

	public DuplicateTaskException(String message) {
		super(message);
	}
}

/**
 * Exception thrown when a requested task is not found.
 */
class TaskNotFoundException extends Exception {
	private static final long serialVersionUID = 1L; // googled because i ran into a warning

	public TaskNotFoundException(String message) {
		super(message);
	}
}

/**
 * Manages tasks by name, allowing operations like add, retrieve, update, and
 * group by status.
 */
public class TaskManager {
	private Map<String, Task> tasks = new HashMap<>();

	/**
	 * Adds a new task.
	 * 
	 * @param name     task name (must be unique)
	 * @param priority task priority
	 * @param status   task status (TODO, IN_PROGRESS, DONE)
	 * @throws DuplicateTaskException if task with same name already exists
	 */
	public void addTask(String name, int priority, String status) throws DuplicateTaskException {
		if (tasks.containsKey(name)) {
			throw new DuplicateTaskException("Task '" + name + "' already exists.");
		}
		tasks.put(name, new Task(name, priority, status));
	}

	/**
	 * Retrieves a task by name.
	 * 
	 * @param name task name
	 * @return Task object
	 * @throws TaskNotFoundException if no task with that name exists
	 */
	public Task getTaskByName(String name) throws TaskNotFoundException {
		if (!tasks.containsKey(name)) {
			throw new TaskNotFoundException("Task '" + name + "' not found.");
		}
		return tasks.get(name);
	}

	/**
	 * Updates the status of an existing task.
	 * 
	 * @param name      task name
	 * @param newStatus new status to apply
	 * @throws TaskNotFoundException if task is not found
	 */
	public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
		Task task = getTaskByName(name);
		task.setStatus(newStatus);
	}

	/**
	 * Prints all tasks grouped by their status.
	 */
	public void printTasksGroupedByStatus() {
		Map<String, List<Task>> grouped = new HashMap<>();
		for (Task task : tasks.values()) {
			grouped.computeIfAbsent(task.getStatus(), _ -> new ArrayList<>()).add(task);
		}
		System.out.println("Tasks grouped by status:");
		for (String status : List.of("TODO", "IN_PROGRESS", "DONE")) {
			System.out.println(status + ":");
			for (Task task : grouped.getOrDefault(status, new ArrayList<>())) {
				System.out.println("  " + task);
			}
		}
	}
}
