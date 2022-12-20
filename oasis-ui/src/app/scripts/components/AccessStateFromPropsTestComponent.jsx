import React from "react";
import {connect, useDispatch} from "react-redux";
import {useCallback} from "react";
import {fetchJobs} from "../actions/JobActions";

const AccessStateFromPropsTestComponent = (props) => {
    const { state } = props;
    const dispatch = useDispatch();
    const clickHandler = useCallback(() => {dispatch(fetchJobs())}, [])

    return(
        <>
            <button onClick={clickHandler}>
                Click me
            </button>
        </>
    )
}

export default connect()(AccessStateFromPropsTestComponent)