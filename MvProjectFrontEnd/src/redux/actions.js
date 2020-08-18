import { SEND_MODIFY_EVENT } from "./actionTypes";


export const sendEventMessage = content => ({
  type: SEND_MODIFY_EVENT,
  payload: {
    modify: true
  }
});

