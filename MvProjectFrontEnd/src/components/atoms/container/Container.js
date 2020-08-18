import React from 'react';
import styled from 'styled-components';
const StyledContainer = (props) => {
    return (<div {...props}>{props.children}</div>
    );
}
export const Container = styled(StyledContainer)`
    
    display:${(props) => props.display==='flex'? 'flex' : 'block'};
    flex-direction:${(props) => props.direction ? 'column' : 'row'};
    align-items:${(props) => props.alignitems};
    justify-content:${(props) => props.justify};
    padding: ${(props) => props.padding};
    background-color: #487878;
    height: 100%;
    width: 100%;

`