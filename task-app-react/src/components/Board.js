import React, { Component } from "react";
import { connect } from "react-redux";
import { getAllColumns } from "../actions/ColumnActions";
import { DragDropContext } from "react-beautiful-dnd";
import Column from "./Column";

export class Board extends Component {
  componentDidMount() {
    this.props.getAllColumns();
  }

  onDragEnd = result => {};

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
  { getAllColumns }
)(Board);
