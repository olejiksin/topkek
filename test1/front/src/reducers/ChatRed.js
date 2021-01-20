import {UPDATE_MESS, MESS_STARTED, MESS_ERROR, MESS_SUCCESS} from "../types/types";

export const chatState = {
    messages: [],
    activeUsers: [],
    error: null,
    loading: false
};

export function reducer(state = chatState, action) {
    switch (action.type) {
        case MESS_STARTED: {
            return {
                ...state,
                loading: true
            }
        }
        case MESS_SUCCESS: {
            console.log('get')
            return {
                ...state,
                messages: action.payload.messageDtoList,
                activeUsers: action.payload.onlineUserList,
                loading: false
            }
        }
        case UPDATE_MESS:
            console.log("payload");
            console.log([state.messages,action.payload.message]);
            console.log(state.messages[0]);
            state.messages[0].message='KEKE';
            return {
                ...state,
                messages: [...state.messages, action.payload]
            };
        case MESS_ERROR: {
            return {
                ...state,
                error: action.payload.error
            };
        }
        default: {
            return state;
        }
    }
}
