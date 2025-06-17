const express = require('express');

const router = express.Router();

router.get('/', (req, res) => {
  res.send('list page');
});

router.get('/:dept', (req, res) => {
  const dept = req.params.dept;
  res.send(`detail(${dept}번) page`);
});

module.exports = router;
