import axios from 'axios';

export const uploadFile = (file) => {
  const data = new FormData();
  data.append('file', file);
  return axios
      .post('http://localhost:8080/upload', data, {});
};

export const getZipCodesByPopulation = (start, end) => {
  return axios
      .get('http://localhost:8080/census/population/range', {
        params: {
          start,
          end,
        }
      });
};

export const getZipCodesByMedianAge = (start, end) => {
  return axios
      .get('http://localhost:8080/census/population/medianage', {
        params: {
          start,
          end,
        }
      });
};

export const getZipCodesMostPopulated = (top) => {
  return axios
      .get('http://localhost:8080/census/population/populated',{
        params: {
          top
        }
      });
};

export const getZipCodesByGender = () => {
  return axios
      .get('http://localhost:8080/census/population/diff/female');
};