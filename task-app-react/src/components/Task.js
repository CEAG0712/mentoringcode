import React, { Component } from "react";
import { Draggable } from "react-beautiful-dnd";

export class Task extends Component {
  render() {
    const { task, index } = this.props;
    return (
      <Draggable draggableId={task.id} index={index}>
        {provided => (
          <li
            className="list-group-item d-flex justify-content-between align-items-center"
            {...provided.draggableProps}
            {...provided.dragHandleProps}
            ref={provided.innerRef}
          >
            {task.content}
            <span className="badge badge-primary badge-pill">
              {task.taskId}
            </span>
          </li>
        )}
      </Draggable>
    );
  }
}

export default Task;
