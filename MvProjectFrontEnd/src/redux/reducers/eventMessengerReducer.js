import { SEND_MODIFY_EVENT } from "../actionTypes";

const initialState = {
  modified: "sdalkfmlaksdf"
};

export default function (state = initialState, action) {
  switch (action.type) {
    case SEND_MODIFY_EVENT: {
      const { modify } = action.payload;
      return {
        ...state,
        modified: modify
      };
    }

    default:
      return state;
  }
}
