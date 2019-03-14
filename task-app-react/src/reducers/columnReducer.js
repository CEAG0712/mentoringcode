import { GET_ALL_COLUMNS, UPDATE_COLUMNS } from "../actions/ActionTypes";

const initialState = {
  columns: []
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_ALL_COLUMNS:
      return {
        ...state,
        columns: action.payload
      };
    case UPDATE_COLUMNS:
      return {
        ...state,
        columns: state.columns.map(column =>
          column.colId === action.payload.colId
            ? (column = action.payload)
            : column
        )
      };
    default:
      return state;
  }
}
