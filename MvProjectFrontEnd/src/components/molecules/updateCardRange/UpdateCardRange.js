import React, { useState } from 'react';
import styled from "styled-components";
import { StyledButton } from '../../atoms/button/StyledButton';
import { updateProductPriceByPercentrange } from '../../../middleware/serviceHandler';

export default function UpdateCardRange() {

    const [range1, setRange1] = useState('');
    const [range2, setRange2] = useState('');
    const [preco, setPreco] = useState();


    function updatePrecoValue(e) {
        setPreco(e.target.value);
    }


    function updateRange1Value(e) {
        setRange1(e.target.value);
    }
    function updateRange2Value(e) {
        setRange2(e.target.value);

    }
    function updateProductPriceByPercentrangeReloader(range1, range2, preco) {
        updateProductPriceByPercentrange(range1, range2, preco);
        window.location.reload(false);
    }

    return (

        <NewCard>

            <Column>
                <h3>Atualizar produtos por range percentual</h3>
                Valor inicial do intervalo Nr_percentual:<input type='text' placeholder='valor inicial do intervalo' value={range1} onChange={e => updateRange1Value(e)}></input>
                Valor inicial do intervalo Nr_percentual:<input type='text' placeholder='valor final do intervalo' value={range2} onChange={e => updateRange2Value(e)}></input>
                valor percentual de aumento de preco(%): <input type='text' placeholder='valor percentual de aumento de preco' value={preco} onChange={e => updatePrecoValue(e)}></input>


            </Column>
            <StyledButton onClick={() => updateProductPriceByPercentrangeReloader(range1, range2, preco)}>Atualizar</StyledButton>


        </NewCard>
    )
}

export const NewCard = styled.div`
    width: 65%;
    height: 100%;
    background-color: white;
    border-radius: 8px;
    display: flex;
    padding: 30px;
    justify-content: space-between;
    align-items: center;
    

`

export const Column = styled.div`
    display: flex;
    flex-direction: column;
    width: 80%;
    input {
        margin: 20px;
    }
`