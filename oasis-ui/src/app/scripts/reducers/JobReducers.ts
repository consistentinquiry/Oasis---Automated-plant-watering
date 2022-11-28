import {GET_JOB} from "../actions/JobActions";
import {Action} from "../utils/ActionTypeUtils";
import {Actions, PayloadAction} from "@reduxjs/toolkit";

const defaultState = {jobs: {}};

export default function JobReducers(state = defaultState, action: PayloadAction) {
    switch(action.type){
        case GET_JOB:
            return {
                ...state,
                jobs: action.payload,
            }
        default:
            return state;
    }
}
