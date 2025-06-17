const { MongoClient } = require('mongodb');

var url = 'mongodb://localhost:27017/mydb';
var client = new MongoClient(url);

(async () => {
  await client.connect();
  const dbo = client.db();
  //최초, collection create
  //   const coll = await dbo.createCollection('documents');
  //if collection exists
  const collection = await dbo.collection('documents');
  //   console.log(coll);

  // Insert Many
  //   const insertResult = await collection.insertMany([{ a: 1 }, { a: 2 }, { a: 3 }]);

  //insert One
  const insertResult = await collection.insertOne({ a: 2 });
  console.log('Inserted documents =>', insertResult);

  //update One
  const updateResult = await collection.updateOne({ a: 3 }, { $set: { b: 3 } });
  console.log('Updated documents =>', updateResult);

  //delete One
  const deleteResult = await collection.deleteMany({ a: 2 });
  console.log('Deleted documents =>', deleteResult);

  //select all
  const findResult = await collection.find({}).toArray();
  console.log('Found documents =>', findResult);

  //select one
  //   const findResult = await collection.find({ a: 3 }).toArray();
  //   console.log('Found documents =>', findResult);

  client.close();
})();
