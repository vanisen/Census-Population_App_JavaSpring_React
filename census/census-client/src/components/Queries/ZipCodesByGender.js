import React from 'react';
import {Card, Button} from 'react-bootstrap';
import {getZipCodesByGender} from "../../services/index";

const ZipCodesByGender = ({active, setOutput}) => {

  const handleSubmit = async () => {
    const output = await getZipCodesByGender();
    setOutput({...output, query: 'gender'});
  };

  return (
      <Card bg={active ? 'light' :''} className="mb-2">
        <Card.Body>
          <Card.Title>Zipcodes with more females than males ordered by the difference descending.</Card.Title>
          <Button variant="primary" onClick={handleSubmit}>Submit</Button>
        </Card.Body>
      </Card>
  );
};

export default ZipCodesByGender;