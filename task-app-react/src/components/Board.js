import React, { Component } from "react";
import { connect } from "react-redux";
import { getAllColumns, dragNdrop } from "../actions/ColumnActions";
import { DragDropContext } from "react-beautiful-dnd";
import Column from "./Column";

export class Board extends Component {
  componentDidMount() {
    this.props.getAllColumns();
  }

  onDragEnd = result => {
    const { destination, source, draggableId } = result;
    if (!destination) {
      return;
    }
    //The user dropped the item back to the position that it started
    if (
      destination.droppableId === source.droppableId &&
      destination.index === source.index
    ) {
      return;
    }
    const column = this.props.columns[0];
    console.log(column.taskList);

    const newColIndex = Array.from(column.taskList);

    newColIndex.splice(source.index, 1);

    newColIndex.splice(destination.index, 0, draggableId);
    console.log("***AFTER DROP***");

    console.log(newColIndex);

    const newColumn = {
      ...column,
      taskList: newColIndex
    };

    this.props.dragNdrop(newColumn);
    // console.log(newColumn);

    // const newState = {
    //   ...this.props,
    //   columns: {
    //     ...this.props.columns[0],
    //     [newColumn.id]: newColumn
    //   }
    // };
    // this.setState(newState);
  };

  render() {
    const { columns } = this.props;

    const column = columns.map(column => {
      return <Column key={column.colId} column={column} />;
    });
    return (
      <div className="container mt-5">
        <DragDropContext onDragEnd={this.onDragEnd}>
          <div className="row">{column}</div>
        </DragDropContext>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  columns: state.column.columns
});

export default connect(
  mapStateToProps,
  { getAllColumns, dragNdrop }
)(Board);
