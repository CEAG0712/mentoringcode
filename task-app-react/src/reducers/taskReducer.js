import { GET_ALL_TASKS } from "../actions/ActionTypes";

const initialState = {
  tasks: []
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_ALL_TASKS:
      return {
        ...state,
        tasks: action.payload
      };
    default:
      return state;
  }
}
