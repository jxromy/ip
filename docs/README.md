# Chai User Guide

### Welcome to **Chai**! 
This guide will provide you with all the information you need to use **Chai**. Whether you're talking to Chai
for task management or other functionalities, this guide covers all of his interactive features.

---

## Features

### 1. **Add a Task**
To add a new task, you can use one of the following commands:

- **To-Do Task**  
  `todo <task description>`  
  Example: `todo read a book`

- **Deadline Task**  
  `deadline <task description> /by <date>`  
  Example: `deadline return book /by 2022-12-01`

- **Event Task**  
  `event <task description> /from <start date> /to <end date>`  
  Example: `event team meeting /from 2022-12-01 10:00 /to 2022-12-01 12:00`

### 2. **Mark Task as Done**
To mark a task as done, use the `mark` command:

- `mark <task number>`  
  Example: `mark 2`  
  This will mark the task with the specified number as completed.

### 3. **Unmark Task**
To unmark a task (i.e., set it back to incomplete), use the `unmark` command:

- `unmark <task number>`  
  Example: `unmark 2`  
  This will unmark the task with the specified number.

### 4. **Delete Task**
To delete a task from the list, use the `delete` command:

- `delete <task number>`  
  Example: `delete 2`  
  This will delete the task with the specified number.

### 5. **List All Tasks**
To view all the tasks in your list, simply use the `list` command:

- `list`  
  Example: `list`  
  This will display all the tasks in your current list, showing their completion status and due dates (if applicable).

### 6. **Find a Task**
To search for tasks that contain a specific keyword in their description, use the `find` command:

- `find <keyword>`  
  Example: `find book`  
  This will display all the tasks that contain the word "book" in their description.

### 7. **Exit**
To exit the application, use the `bye` command:

- `bye`  
  Example: `bye`  
  This will exit the chatbot and close the application.

---

## Example Interactions

Here are a few examples of commands you can use:

- **Adding a Task**  
  `todo read a book`  
  Adds a To-Do task with the description "read a book".

- **Adding a Deadline Task**  
  `deadline return book /by 2022-12-01`  
  Adds a Deadline task with the description "return book" and a due date of 2022-12-01.

- **Marking a Task as Done**  
  `mark 2`  
  Marks the task with task number 2 as done.

- **Finding Tasks**  
  `find book`  
  Finds tasks that contain the word "book" in their description.

- **Exiting the Chatbot**  
  `bye`  
  Exits the chatbot.

---

## Error Handling

If you enter an invalid command or something goes wrong, **Chai** will notify you with a friendly error message and prompt you to try again.

---

## Command Summary Table

| Command                | Description                                                                 | Example Usage                                           |
|------------------------|-----------------------------------------------------------------------------|---------------------------------------------------------|
| `todo <task description>`   | Adds a To-Do task with the specified description.                            | `todo read a book`                                      |
| `deadline <task description> /by <date>` | Adds a Deadline task with the specified description and due date.  | `deadline return book /by 2022-12-01`                   |
| `event <task description> /from <start> /to <end>` | Adds an Event task with the specified description, start and end times. | `event team meeting /from 2022-12-01 10:00 /to 2022-12-01 12:00` |
| `mark <task number>`        | Marks the specified task as done.                                            | `mark 2`                                                |
| `unmark <task number>`      | Unmarks the specified task (sets it back to incomplete).                     | `unmark 2`                                              |
| `delete <task number>`      | Deletes the specified task.                                                  | `delete 2`                                              |
| `list`                      | Displays all tasks in the current list.                                      | `list`                                                  |
| `find <keyword>`            | Searches for tasks containing the specified keyword in the description.     | `find book`                                             |
| `bye`                       | Exits the chatbot.                                                           | `bye`                                                   |

---

## Conclusion

That's it! You're now ready to use **Chai** to manage your tasks effectively. Feel free to explore and start managing your tasks with ease.

For any issues or additional help, please refer to the FAQs or contact support.