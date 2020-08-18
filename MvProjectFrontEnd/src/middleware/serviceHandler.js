import api from '../api'

export const getProducts = async function getProducts(headers) {
    return api.get('api/produto', headers)
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.log("erro na chamada do servico", error);
            return error.response;
        });
}

export const getCategories = async function getCategories(headers) {
    return api.get('api/categorias', headers)
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.log("erro na chamada do servico", error);
            return error.response;
        });
}

export const insertProduct = async function insertProduct(codigo, categoria, descricao, preco) {
    var url = `api/produto?codigo=${codigo}&categoria=${categoria}&preco=${preco}`;


    return api.put(url, descricao, {})
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.log("erro na chamada do servico", error);
            return error.response;
        });
}

export const deleteProduct = async function deleteProduct(codigo) {
    var url = `api/produto?codigo=${codigo}`;

    console.log(url);
    api.delete(url)
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.log("erro na chamada do servico", error);
            return error.response;
        });
}

export const updateProduct = async function updateProduct(codigo, categoria, descricao, preco) {
    var url = `api/produto?codigo=${codigo}&categoria=${categoria}&preco=${preco}`;


    return api.post(url, descricao, {})
        .then(function (response) {
            console.log(response);

        });
}

export const updateProductPriceByCategory = async function updateProductPriceByCategory(categoria, aumentoPercentual) {
    var url = `api/atualizaproduto/porcategoria?categoria=${categoria}&aumentoPercentual=${aumentoPercentual}`;
    console.log(url);

    return api.post(url, '', {})
        .then(function (response) {
            console.log(response);

        });
}

export const updateProductPriceByPercentrange = async function updateProductPriceByPercentrange(range1, range2, aumentoPercentual) {
    var url = `api/atualizaproduto/porfaixadeporcentagem?rangeUm=${range1}&rangeDois=${range2}&aumentoPercentual=${aumentoPercentual}`;
    console.log(url);

    return api.post(url, '', {})
        .then(function (response) {
            console.log(response);

        });
}