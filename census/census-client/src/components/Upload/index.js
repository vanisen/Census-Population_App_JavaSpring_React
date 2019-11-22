import React, {useState} from 'react';
import {Card} from 'react-bootstrap';
import {uploadFile} from "../../services/index";

const Upload = ({active, setOutput}) => {
  
  const [file, setFile] = useState();
  
  const handleChange = (e) => {
    setFile(e.target.files[0]);
    console.log('set file', file);
  };
  
  const handleUpload = async () => {
    try{
      const output = await uploadFile(file);
      setOutput({...output, query:'upload'});
    }catch(e){
      setOutput({...e, query:'upload'});
    }
  };
  
  return (
      <Card bg={active ? 'light' :''} className="mb-2">
        <Card.Body>
          <Card.Title>Upload CSV file to database</Card.Title>
          <Card.Text>
            <label>
              Please select the csv file
              <input type="file" name="csv_file" className="btn btn-secondqry" onChange={handleChange}/>
            </label>
            <br/>
            <button className="btn btn-primary" onClick={handleUpload}>Upload</button>
          </Card.Text>
        </Card.Body>
      </Card>
  )
};

export default Upload;