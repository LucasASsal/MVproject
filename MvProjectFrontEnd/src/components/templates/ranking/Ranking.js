import React, { useState, useEffect } from 'react';
import { Accordion } from '../../molecules/accordion/Accordion';
import { Container } from '../../atoms/container/Container'
import CreateCard from '../../molecules/createCard/CreateCard';
import UpdateCardCategory from '../../molecules/updateCardCategory/UpdateCardCategory';
import UpdateCardRange from '../../molecules/updateCardRange/UpdateCardRange';
import { getProducts, getCategories } from '../../../middleware/serviceHandler';


const Ranking = (props) => {
    const [listaProdutos, setListaProdutos] = useState(['']);
    const [listaCategorias, setListaCategorias] = useState(['']);
    var config = {
        headers: {}
    };
    useEffect(() => {
        getProducts(config).then((res) => setListaProdutos(res));
        getCategories(config).then((res) => setListaCategorias(res));
    }, [])





    return (

        <Container display='flex' direction='column' alignitems='center' justify='center' padding='50px'  >

            <CreateCard categorias={listaCategorias} />
            <br />
            <UpdateCardCategory categorias={listaCategorias} />
            <br />
            <UpdateCardRange />
            <h1>Lista de Produtos Cadastrados</h1>
            {(listaProdutos != null) && listaProdutos.map((produto) => <Accordion key={produto.codigo} codigo={produto.codigo} name={produto.descricao} preco={produto.preco} categoria={produto.categoria} categorias={listaCategorias} />)}
        </Container>

    );
}

export default Ranking;