import React, { Component } from "react";
import Task from "./Task";
import { Droppable } from "react-beautiful-dnd";

class Column extends Component {
  render() {
    const { column } = this.props;

    return (
      <React.Fragment>
        <div className="col-md-4">
          <div className="card-header bg-secondary text-center">
            <h3>{column.title}</h3>
          </div>
          {
            //render props pattern : dnd does not need to create a DOM node
            //monkey patch?
          }
          <Droppable droppableId={column.colId}>
            {provided => (
              <ul
                className="list-group"
                ref={provided.innerRef}
                {...provided.droppableProps}
              >
                {column.taskList
                  //https://www.w3schools.com/jsref/jsref_sort.asp
                  .sort((task1, task2) => task1.colIndex - task2.colIndex)
                  .map((task, index) => (
                    <Task key={task.taskId} task={task} index={index} />
                  ))}
                {provided.placeholder}
              </ul>
            )}
          </Droppable>
        </div>
      </React.Fragment>
    );
  }
}

export default Column;
